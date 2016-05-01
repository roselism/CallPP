package com.roselism.callpp.base;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T> View的子类,可以指定ViewHolder中要返回的根视图
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName base
 * @更新时间 2016/4/30 14:29
 * @描述 ViewHolder的基类
 */
public abstract class BaseViewHolder<T extends View, V> {

    protected List<V> mDatas = new ArrayList<>();
    protected Context mContext;
    private T mRootView;//根视图

    public BaseViewHolder(Context context) {
        mContext = context;
        mRootView = initRootView();
        initData();
        mRootView.setTag(this);
    }

    /**
     * 初始化根视图
     */
    protected abstract T initRootView();

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 获取根视图
     *
     * @return
     */
    public T getRootView() {
        return mRootView;
    }

}
