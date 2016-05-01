package com.roselism.callpp.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.roselism.callpp.adapter.HomeRecyclerAdapter;
import com.roselism.callpp.base.BaseViewHolder;
import com.roselism.callpp.base.RecyclerViewAdapter;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/4/30 14:27
 * @描述 首页的ViewHolder
 */
public class HomeViewHolder extends BaseViewHolder<RecyclerView, String> implements RecyclerViewAdapter.OnItemLongClickListener, RecyclerViewAdapter.OnItemClickListener {
    public HomeViewHolder(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView initRootView() {
        return new RecyclerView(mContext);
    }

    @Override
    protected void initData() {
        RecyclerView recyclerView = getRootView();
        setData();
        HomeRecyclerAdapter recyclerAdapter = new HomeRecyclerAdapter(mDatas);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        recyclerAdapter.setOnItemClickListener(this);
        recyclerAdapter.setOnItemLongClickListener(this);
    }

    /**
     * 设置数据
     */
    private void setData() {
        for (int i = 0; i < 100; i++) {
            mDatas.add("第" + i + "条数据");
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {
        Toast.makeText(mContext, "长按:" + mDatas.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(mContext, "点击:" + mDatas.get(position), Toast.LENGTH_SHORT).show();
    }
}
