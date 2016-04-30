package com.roselism.callpp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp
 * @更新时间 2016/4/30 20:55
 * @描述 全局唯一的Application类
 */
public class CallppApplication extends Application {
    private static Context mContext;
    private static int     mMainThreadId;
    //主线程Handler
    private static Handler mMainHandler = new Handler();

    public static Context getContext() {
        return mContext;
    }

    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Handler getMainHandler() {
        return mMainHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化一些常见的属性放在myApplication中
        mContext = getApplicationContext();
        //主线程ID
        mMainThreadId = android.os.Process.myTid();
    }
}
