package com.pans.libbase.network.response;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import com.pans.libbase.network.exception.ApiException;
import com.pans.libbase.util.ReflectUtil;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 * 1.线程调度
 * 2.rxjava生命周期管理
 * 3.数据统一处理
 */
public class ResponseTransformer<T> implements ObservableTransformer<IResponse<T>, T>, LifecycleObserver {

    final CompositeDisposable compositeDisposable = new CompositeDisposable();

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void onDestroy() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    @NonNull
    @Override
    public ObservableSource<T> apply(@NonNull Observable<IResponse<T>> upstream) {
        return upstream.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {
                compositeDisposable.add(disposable);
            }
        }).onErrorResumeNext(new Function<Throwable, ObservableSource<? extends IResponse<T>>>() {
            @Override
            public ObservableSource<? extends IResponse<T>> apply(@NonNull Throwable throwable) throws Exception {
                return Observable.error(ApiException.handleException(throwable));
            }
        }).flatMap(new Function<IResponse<T>, ObservableSource<T>>() {
            @Override
            public ObservableSource<T> apply(@NonNull IResponse<T> response) throws Exception {
                if (response.isSuccess()) {
                    if (response.getData() != null) {
                        return Observable.just(response.getData());
                    } else {
                        //反射创建data
                        Class<?> clz = ReflectUtil.analysisClassInfo(response);
                        T obj = (T) clz.newInstance();
                        return Observable.just(obj);
                    }
                }
                return Observable.error(new ApiException(response.getCode(), response.getMessage()));
            }
        }).subscribeOn(Schedulers.io())//请求线程
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ResponseTransformer<T> obtain(LifecycleOwner lifecycleOwner) {
        ResponseTransformer<T> transformer = new ResponseTransformer<>();
        lifecycleOwner.getLifecycle().addObserver(transformer);
        return transformer;
    }
}
