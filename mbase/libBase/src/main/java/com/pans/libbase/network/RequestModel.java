package com.pans.libbase.network;

import androidx.lifecycle.LifecycleOwner;

import com.pans.libbase.network.exception.ApiException;
import com.pans.libbase.network.response.ICallback;
import com.pans.libbase.network.response.IResponse;
import com.pans.libbase.network.response.ResponseTransformer;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public class RequestModel {

    public static <T> void request(Observable<? extends IResponse<T>> o, LifecycleOwner lifecycleOwner, ICallback<T> callback) {
        Disposable disposable = o.compose(ResponseTransformer.obtain(lifecycleOwner))
                .subscribe(new Consumer<T>() {
                    @Override
                    public void accept(T t) throws Exception {
                        callback.onSuccess(t);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callback.onFailure(ApiException.handleException(throwable));
                    }
                });
    }
}
