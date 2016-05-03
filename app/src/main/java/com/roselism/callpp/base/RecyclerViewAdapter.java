package com.roselism.callpp.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roselism.callpp.util.UIUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @param <T> 显示的数据类型
 *
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 19:49
 * @描述 主页面中RecyclerView的Adapter
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter {

    protected Context mContext = UIUtils.getContext();
    protected List<T>                 mDatas;
    protected OnItemClickListener     mItemClickListener;// 点击监听
    protected OnItemLongClickListener mItemLongClickListener;// 长按监听

    public RecyclerViewAdapter(List<T> datas) {
        mDatas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return getViewHolder(parent);
    }

    /**
     * @param parent
     *
     * @return
     */
    protected abstract RecyclerView.ViewHolder getViewHolder(ViewGroup parent);

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewholder = (RecyclerViewAdapter.ViewHolder) holder;
        viewholder.bindData(position);
    }

    /**
     * 给条目设置点击监听
     *
     * @param itemClickListener 点击监听回调接口
     */
    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    /**
     * 给条目设置长按监听
     *
     * @param itemLongClickListener 长按监听回调接口
     */
    public void setOnItemLongClickListener(
            OnItemLongClickListener itemLongClickListener) {
        mItemLongClickListener = itemLongClickListener;
    }

    @Override
    public int getItemCount() {
        if (mDatas != null)
            return mDatas.size();
        return 0;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, int position);
    }

    public abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        /**
         * @param LayoutRes 布局文件
         * @param parent    装布局文件的ViewGroup
         */
        public ViewHolder(@LayoutRes int LayoutRes, ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(LayoutRes, parent, false));
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if (mItemLongClickListener != null) {
                mItemLongClickListener.onItemLongClick(v, getAdapterPosition());
            }
            return true;
        }

        /**
         * 绑定数据
         *
         * @param position position
         */
        public abstract void bindData(int position);
    }
}
