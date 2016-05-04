package com.roselism.callpp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by simon on 2016/4/30.
 */
public class CallppApplication extends Application {

    private static Handler sMainHandler = new Handler();

    private static Context sContext;// Application的上下文
    private static int sMainThreadId;// 主线程Handler

    /**
     * 获取context
     *
     * @return application的context
     */
    public static Context getContext() {
        return sContext;
    }

    /**
     * 获取主线程ID
     *
     * @return 主线程ID
     */
    public static int getMainThreadId() {
        return sMainThreadId;
    }


    public static Handler getMainHandler() {
        return sMainHandler;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sContext = getApplicationContext();
        sMainThreadId = android.os.Process.myTid();
    }
}
