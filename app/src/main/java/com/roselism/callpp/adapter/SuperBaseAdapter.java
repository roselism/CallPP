package com.roselism.callpp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.roselism.callpp.adapter.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 15:27
 * @描述 TODO
 * @deprecated 由于ListView 替换成RecyclerView所以该类弃用
 */
@Deprecated
public abstract class SuperBaseAdapter<VIEWHOLDER extends BaseViewHolder, DATA> extends BaseAdapter {
    protected Context    mContext;
    protected List<DATA> mData;


    public SuperBaseAdapter(Context context, List<DATA> data) {
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
        VIEWHOLDER holder;
        if (convertView == null) {
            holder = initViewHolder();
            convertView = holder.getRootView();
            convertView.setTag(holder);
        } else {
            holder = (VIEWHOLDER) convertView.getTag();
        }
        bindData(holder, position);
        return convertView;
    }

    /**
     * 绑定数据
     *
     * @param holder
     * @param position
     */
    protected abstract void bindData(VIEWHOLDER holder, int position);

    /**
     * 初始化根视图的ViewHolder
     *
     * @return
     */
    protected abstract VIEWHOLDER initViewHolder();
}
