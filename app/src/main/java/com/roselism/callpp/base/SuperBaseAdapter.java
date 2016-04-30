package com.roselism.callpp.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 15:27
 * @描述 TODO
 */
public abstract class SuperBaseAdapter<E extends BaseViewHolder,T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mData;


    public SuperBaseAdapter(Context context, List<T> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getCount() {
        if (mData != null)
            return mData.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        E holder;
        if (convertView == null) {
            holder = initViewHolder();
            convertView = holder.getRootView();
            convertView.setTag(holder);
        } else {
            holder = (E) convertView.getTag();
        }
        bindData(holder,position);
        return convertView;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    protected abstract void bindData(E holder, int position);

    /**
     * 初始化根视图的ViewHolder
     *
     * @return
     */
    protected abstract E initViewHolder();
}
