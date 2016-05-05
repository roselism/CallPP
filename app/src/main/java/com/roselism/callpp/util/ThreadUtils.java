package com.roselism.callpp.util;

import android.os.Handler;

import com.roselism.callpp.CallppApplication;

/**
 * @创建者 lai
 * @创建时间 2016/4/2
 * @packageName com.communication.utils
 * @更新时间 2016/4/2 20:08
 * @描述 在不同的线程之间切换的工具类
 */
public class ThreadUtils {
    public static Handler mHandler = CallppApplication.getMainHandler();

    /**
     * 在UI线程中执行任务
     *
     * @param task 要执行的任务
     */
    public static void runInUIThread(Runnable task) {
        mHandler.post(task);
    }

    /**
     * 在子线程中执行任务
     *
     * @param task 要执行的任务
     */
    public static void runInThread(Runnable task) {
        new Thread(task).start();
    }

    /**
     * 延迟在UI线程中执行任务
     * @param task 要执行的任务
     * @param delay 延迟的毫秒值
     */
    public static void runInUIThread(Runnable task,long delay){
        mHandler.postDelayed(task, delay);
    }
}
