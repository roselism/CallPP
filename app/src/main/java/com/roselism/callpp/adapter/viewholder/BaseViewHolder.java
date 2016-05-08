package com.roselism.callpp.adapter.viewholder;

import android.content.Context;
import android.view.View;

import java.util.List;

/**
 * @param <VIEW> View的子类,可以指定ViewHolder中要返回的根视图
 *
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName base
 * @更新时间 2016/4/30 14:29
 * @描述 ViewHolder的基类
 */
public abstract class BaseViewHolder<VIEW extends View, DATA> {

    protected List<DATA> mDatas;
    private   VIEW       mRootView;//根视图
    protected Context    mContext;

    public BaseViewHolder(Context context) {
        mContext = context;
        mRootView = initRootView();
        initListener();
        mRootView.setTag(this);
    }

    protected void initListener() {
    }

    /**
     * 初始化根视图
     */
    protected abstract VIEW initRootView();


    /**
     * 获取根视图
     *
     * @return
     */
    public VIEW getRootView() {
        return mRootView;
    }

}
