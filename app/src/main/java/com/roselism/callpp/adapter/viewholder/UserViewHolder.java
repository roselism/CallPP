package com.roselism.callpp.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.roselism.callpp.adapter.RecyclerViewAdapter;
import com.roselism.callpp.adapter.UserRecyclerAdapter;

import java.util.ArrayList;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/4/30 14:28
 * @描述 用户设置的ViewHolder
 */
public class UserViewHolder extends CommonViewHolder<RecyclerView, String> implements RecyclerViewAdapter.OnItemClickListener {
    public UserViewHolder(Context context) {
        super(context);
    }

    @Override
    protected RecyclerView initRootView() {
        return new RecyclerView(mContext);
    }

    @Override
    protected void initData() {
        RecyclerView recyclerView =  getRootView();
        setData();
        UserRecyclerAdapter adapter = new UserRecyclerAdapter(mDatas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        adapter.setOnItemClickListener(this);
    }

    private void setData() {
        mDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mDatas.add("第" + i + "条数据");
        }
    }

    @Override
    protected void bindViewAndData() {

    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(mContext, mDatas.get(position), Toast.LENGTH_SHORT).show();
    }
}
