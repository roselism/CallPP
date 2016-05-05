package com.roselism.callpp.model.observer;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/3 0:04
 * @描述
 */
public interface Subject {
    /**
     * 注册成为观察者
     *
     * @param observer 要成为观察者的目标
     */
    void registerObserver(DataChangeObserver observer);
    /**
     * 数据发生改变,通知观察者
     */
    void notifyObserver();
    /**
     * 移除观察者
     * @param observer 要移除的观察者
     */
    void removeObserver(DataChangeObserver observer);
}
