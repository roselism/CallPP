package com.roselism.callpp.adapter.viewholder;

import android.content.Context;
import android.view.View;

/**
 * @创建者 lai
 * @创建时间 2016/5/7
 * @packageName com.roselism.callpp.adapter.viewholder
 * @更新时间 2016/5/7 22:44
 * @描述 需要绑定数据的ViewHolder基类
 */
public abstract class CommonViewHolder<VIEW extends View, DATA> extends BaseViewHolder<VIEW,DATA> {
    public CommonViewHolder(Context context) {
        super(context);
        initData();
        bindViewAndData();
    }

    /**
     * 初始化数据
     */
    protected abstract void initData() ;

    protected abstract void bindViewAndData();
}
