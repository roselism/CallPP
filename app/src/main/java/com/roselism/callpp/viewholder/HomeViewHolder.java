package com.roselism.callpp.viewholder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.roselism.callpp.adapter.HomeRecyclerAdapter;
import com.roselism.callpp.base.BaseViewHolder;
import com.roselism.callpp.base.RecyclerViewAdapter;
import com.roselism.callpp.model.observer.DataChangeObserver;
import com.roselism.callpp.model.observer.DataChangeSubject;
import com.roselism.callpp.model.bean.ContactInfo;
import com.roselism.callpp.util.ContactUtil;
import com.roselism.callpp.util.ThreadUtils;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/4/30 14:27
 * @描述 首页的ViewHolder
 */
public class HomeViewHolder extends BaseViewHolder<RecyclerView, ContactInfo> implements RecyclerViewAdapter.OnItemLongClickListener, RecyclerViewAdapter.OnItemClickListener,DataChangeObserver {

    private HomeRecyclerAdapter mRecyclerAdapter;

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
        mRecyclerAdapter = new HomeRecyclerAdapter(mDatas);
        recyclerView.setAdapter(mRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mRecyclerAdapter.setOnItemClickListener(this);//设置点击事件监听
        mRecyclerAdapter.setOnItemLongClickListener(this);//设置长按事件监听
        DataChangeSubject.getInstance().registerObserver(this);//注册成为观察者
    }

    @Override
    protected void bindViewAndData() {

    }

    /**
     * 设置数据
     */
    private void setData(){
       mDatas = ContactUtil.getAllLocalContact(mContext);
    }

    @Override
    public void update() {
        mDatas = ContactUtil.getAllNetContact();
        ThreadUtils.runInUIThread(new Runnable() {
            @Override
            public void run() {
                mRecyclerAdapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public void onItemLongClick(View view, int position) {
        ContactUtil.callPhone(mDatas.get(position).getNumber());
        Toast.makeText(mContext, "长按:" + mDatas.get(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(View view, int position) {
        showPopupWindow();
        Toast.makeText(mContext, "点击:" + mDatas.get(position), Toast.LENGTH_SHORT).show();
    }

    private void showPopupWindow() {

    }
}
