package com.roselism.callpp.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.roselism.callpp.R;
import com.roselism.callpp.util.UIUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @param <DATA> 显示的数据类型
 *
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 19:49
 * @描述 主页面中RecyclerView的Adapter
 */
public abstract class RecyclerViewAdapter<DATA> extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    protected Context mContext = UIUtils.getContext();
    protected List<DATA>              mDatas;
    protected OnItemClickListener     mItemClickListener;// 点击监听
    protected OnItemLongClickListener mItemLongClickListener;// 长按监听
    protected int VIEWTYPE_NORMAL = 0;
    protected int VIEWTYPE_TITLE  = 1;
    protected int VIEWTYPE_HEAD   = 2;

    public RecyclerViewAdapter(List<DATA> datas) {
        mDatas = datas;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bindData(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEWTYPE_NORMAL) {
            return getNormalViewHolder(parent);
        } else if (viewType == VIEWTYPE_TITLE) {
            return new TitleViewHolder(parent);
        } else if (viewType == VIEWTYPE_HEAD) {
            return getHeadViewHolder(parent);
        }
        return null;
    }

    /**
     * 头部的布局ViewHolder
     * @param parent
     * @return
     */
    protected ViewHolder getHeadViewHolder(ViewGroup parent) {
        return null;
    }

    /**
     * 普通的viewHolder
     * @param parent
     * @return
     */
    protected abstract ViewHolder getNormalViewHolder(ViewGroup parent);

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

    protected abstract class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
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
         * @param position position
         */
        public abstract void bindData(int position);
    }

    protected class TitleViewHolder extends ViewHolder {
        @Bind(R.id.item_title) TextView mItemTitle;

        public TitleViewHolder(ViewGroup parent) {
            super(R.layout.item_title, parent);
        }

        @Override
        public void bindData(int position) {
            mItemTitle.setText(mDatas.get(position).toString());
        }
    }
}
