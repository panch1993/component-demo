package com.pans.libbase.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import androidx.core.content.FileProvider;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by panchenhuan on 2018/6/11 13:46.
 * 常用方法
 */
public class MUtil {

    public static void copyText(String text, Context ctx) {
        ClipboardManager cm = (ClipboardManager) ctx.getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", text);
        cm.setPrimaryClip(mClipData);
    }

    public static int getWindowWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(outMetrics);
            return outMetrics.widthPixels;
        }
        return 0;
    }

    public static int getWindowHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            DisplayMetrics outMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getRealMetrics(outMetrics);
            return outMetrics.heightPixels;
        }
        return 0;
    }

    /**
     * 强制隐藏输入法键盘
     */
    public static void hideInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager == null) return;
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void showInputMethod(Context context, View view) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputMethodManager == null) return;
        inputMethodManager.showSoftInput(view, 0);
    }

    /**
     * 获取版本号
     *
     * @return version code 15
     */
    public static int getVersionCode(Context context) {
        PackageManager pm = context.getPackageManager();//获取包管理器
        try {//获取包信息
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;//返回版本号
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 获取版本名称
     *
     * @return 版本名称 2.0.0
     */
    public static String getVersionName(Context context) {
        PackageManager pm = context.getPackageManager();//获取包管理器
        try {  //获取包信息
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            //返回版本号
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当然系统时间
     *
     * @return 按照给定格式返回当前系统时间
     */
    public static String getCurrTime(String format) {
        SimpleDateFormat df = new SimpleDateFormat(format, Locale.getDefault());//设置日期格式
        return df.format(new Date());
    }

    /**
     * 获取当前时区值
     */
    public static float getTimeZoneFloat() {
        int offsetMinutes = TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 60000;
        float zoneFloat = (float) (offsetMinutes / 60);
        float zoneTemp = Math.abs((float) (offsetMinutes % 60));
        if (zoneTemp > 30) {
            zoneFloat = zoneFloat + 1.0f;
        } else if (zoneTemp == 30.0f) {
            zoneFloat = zoneFloat + 0.5f;
        } else if (zoneTemp > 0) {
            zoneFloat = zoneFloat + 0.0f;
        }
        return zoneFloat;
    }

    /**
     * 获取当前时区
     */
    public static String getTimeZoneString() {
        return String.valueOf(TimeZone.getDefault().getOffset(System.currentTimeMillis()) / 1000);
    }

    /**
     * 判别邮箱 包含aa@qq.vip.com，aa@qq.com
     *
     * @param email 邮箱地址
     */
    public static boolean isEmail(String email) {
        return !TextUtils.isEmpty(email) && email.matches("^[a-zA-Z0-9]+([._\\-]*[a-zA-Z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
    }

    /**
     * 判断是否是电话号码
     *
     * @param mobiles 手机号
     */
    public static boolean isMobileNO(String mobiles) {
        return !TextUtils.isEmpty(mobiles) && mobiles.matches("^1(3[0-9]|4[579]|5[0-35-9]|6[6]|7[0135678]|8[0-9]|9[89])\\d{8}$");
    }


    /**
     * 安装新版APK
     *
     * @param ctx  上下文
     * @param file 安装文件
     */
    public static void installApk(Context ctx, File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            uri = FileProvider.getUriForFile(ctx, ctx.getPackageName() + ".provider", file);
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            uri = Uri.fromFile(file);
        }
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        ctx.startActivity(intent);
    }


    /**
     * 创建文件Uri
     *
     * @param c 上下文
     * @return Uri
     */
    public static Uri generateUri(Context c, File file) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return FileProvider.getUriForFile(c, c.getPackageName() + ".provider", file);
        } else {
            return Uri.fromFile(file);
        }
    }


    /**
     * 根据系统版本获取文件地址
     *
     * @param c   上下文
     * @param uri Uri
     * @return 真实地址
     */
    public static String getSmartFilePath(Context c, Uri uri) {
        return getImageOnKitKat(c, uri);
    }

    /**
     * @param context   上下文
     * @param uri       Uri
     * @param selection 选择串
     * @return 真实地址
     */
    private static String getImagePath(Context context, Uri uri, String selection) {
        String path = null;
        Cursor cursor = context.getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    /**
     * android 4.4以上获取图片真实地址
     *
     * @param context 上下文
     * @param uri     Uri
     * @return 真实地址
     */
    private static String getImageOnKitKat(Context context, Uri uri) {
        String imagePath = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(context, contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imagePath = getImagePath(context, uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return imagePath;
    }
}
