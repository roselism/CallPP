package com.roselism.callpp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 19:49
 * @描述 主页面中RecyclerView的Adapter
 */
public class RecyclerViewAdapter<T> extends RecyclerView.Adapter {

    private List<T> mDatas;
    private OnItemClickListener mItemClickListener;

    public RecyclerViewAdapter(List<T> datas) {
        mDatas = datas;
    }

    /**
     * 给每个条目设置点击监听
     * @param itemClickListener 回调接口
     */
    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        mItemClickListener = itemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (mDatas != null)
            return mDatas.size();
        return 0;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public interface OnItemLongClickListener{
        void onItemClick(View view,int position);
    }

}
