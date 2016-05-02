package com.roselism.callpp.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Handler;
import android.view.WindowManager;

import com.roselism.callpp.CallppApplication;


/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.util
 * @更新时间 2016/4/30 21:04
 * @描述 和UI操作相关的工具类
 */
public class UIUtils {
    /**得到一个上下文*/
    public static Context getContext() {
        return CallppApplication.getContext();
    }

    /**得到Resouce对象*/
    public static Resources getResources() {
        return getContext().getResources();
    }

    /**得到string.xml中的一些字符串*/
    public static String getString(int resId) {
        return getResources().getString(resId);
    }

    /**得到string.xml中的一些字符串,带占位符的情况*/
    public static String getString(int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

    /**得到string.xml中的一些字符串数组*/
    public static String[] getStringArr(int resId) {
        return getResources().getStringArray(resId);
    }

    /**得到color.xml中的一些字符串数组*/
    public static int getColor(int resId) {
        return getResources().getColor(resId);
    }

    /**得到当前的包名*/
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**得到主线程的id*/
    public static long getMainThreadId() {
        return CallppApplication.getMainThreadId();
    }

    /**得到主线程中创建一个handler*/
    public static Handler getMainThreadHandler() {
        return CallppApplication.getMainHandler();
    }

    /**安全的执行一个task*/
    public static void postTaskSafely(Runnable task) {
        // 1.得到当前的线程id
        long curThreadID = android.os.Process.myTid();
        // 2.得到主线程的线程id
        long mainThreadId = getMainThreadId();
        // 如果现在的线程是在主线程-->直接执行任务
        if (curThreadID == mainThreadId) {
            task.run();
        } else {// 如果现在的线程是在子线程-->把该任务,交给主线程的handler执行
            getMainThreadHandler().post(task);
        }
    }

    /**
     * dp-->px
     */
    public static int dip2Px(int dp) {
        // int densityDpi = getResources().getDisplayMetrics().densityDpi;
        float density = getResources().getDisplayMetrics().density;
        // System.out.println("densityDpi:" + densityDpi);
        // System.out.println("density:" + density);
        int px = (int) (dp * density + .5f);
        return px;
    }

    /**
     * px->dp
     */
    public static int px2Dp(int px) {
        // px/dp = density
        int density = getResources().getDisplayMetrics().densityDpi;
        int dp = (int) (px / density + .5f);
        return dp;
    }

    /**
     * 延迟执行任务
     * @param task
     * @param delayMillis
     */
    public static void postTaskDelay(Runnable task, long delayMillis) {
        UIUtils.getMainThreadHandler().postDelayed(task, delayMillis);
    }

    /**
     * 移除一个任务
     * @param task
     */
    public static void removeTask(Runnable task) {
        UIUtils.getMainThreadHandler().removeCallbacks(task);
    }

    /**
     * 获取屏幕大小
     * @return
     */
    public static Point getScreenSize(){
        WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        return point;
    }
}
