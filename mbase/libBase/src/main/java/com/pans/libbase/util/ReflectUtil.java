package com.pans.libbase.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Create by panchenhuan on 2021/8/24
 * walkwindc8@foxmail.com
 * Description:
 */
public class ReflectUtil {

    //反射获取泛型类型
    public static Class<?> analysisClassInfo(Object obj) {
        Type genericSuperclass = obj.getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) genericSuperclass;
        Type[] params = pType.getActualTypeArguments();
        Type type0 = params[0];
        return (Class<?>) type0;
    }
}
