package com.roselism.callpp.model.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/5/2
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/2 23:31
 * @描述 数据发生改变的目标
 */
public class DataChangeSubject implements Subject {
    private static List<DataChangeObserver> mObservers = new ArrayList<>();

    private final static class SingletonHolder {
        private final static DataChangeSubject mSubject = new DataChangeSubject();
    }

    private DataChangeSubject() {
    }

    public static DataChangeSubject getInstance() {
        return SingletonHolder.mSubject;
    }

    @Override
    public void registerObserver(DataChangeObserver observer) {
        mObservers.add(observer);
    }

    @Override
    public void notifyObserver() {
        for (DataChangeObserver mObserver : mObservers) {
            mObserver.update();
        }
    }

    @Override
    public void removeObserver(DataChangeObserver observer) {
        mObservers.remove(observer);
    }
}
