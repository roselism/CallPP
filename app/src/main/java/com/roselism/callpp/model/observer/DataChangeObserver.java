package com.roselism.callpp.model.observer;

/**
 *
 * @创建者 lai
 * @创建时间 2016/5/2
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/2 22:58
 * @描述 数据发生改变时的接口
 */
public interface DataChangeObserver {
    /**
     * 更新数据的方法
     */
    void update();
}
