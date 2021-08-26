package com.pans.libbase.util;

import android.content.Context;
import android.text.TextUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create by panchenhuan on 2021/8/25
 * walkwindc8@foxmail.com
 * Description:
 */
public class PropertiesUtil {

    private static Properties props;

    public static void init(Context context, String fileName) {
        props = new Properties();
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            props.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public static boolean boolProperty(String key, boolean defaultValue) {
        String property = props.getProperty(key);
        return property == null ? defaultValue : TextUtils.equals(property, "true");
    }
}
