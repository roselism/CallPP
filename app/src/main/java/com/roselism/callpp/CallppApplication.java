package com.roselism.callpp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.roselism.callpp.util.LogUtil;

/**
 * Created by simon on 2016/4/30.
 */
public class CallppApplication extends Application {


    private static Handler sMainHandler;

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

        LogUtil.i("onCreate");

        sContext = getApplicationContext();
        sMainThreadId = android.os.Process.myTid();

        sMainHandler = new Handler();

        //        LogUtil.setIsDebug(true); // 开启debug模式

        //        BmobIniter bmobIniter = new BmobIniter(sContext); // 初始化bmob全局变量
        //        bmobIniter.initBmob();

    }

}
