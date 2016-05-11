package com.roselism.callpp.adapter.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.roselism.callpp.adapter.HomeRecyclerAdapter;
import com.roselism.callpp.adapter.RecyclerViewAdapter;
import com.roselism.callpp.local.bean.ContactInfo;
import com.roselism.callpp.local.observer.DataChangeObserver;
import com.roselism.callpp.local.observer.DataChangeSubject;
import com.roselism.callpp.util.ContactUtil;
import com.roselism.callpp.util.ThreadUtils;
import com.roselism.callpp.util.UIUtils;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/4/30 14:27
 * @描述 首页的ViewHolder
 */
public class HomeViewHolder extends CommonViewHolder<RecyclerView, ContactInfo>
        implements
        RecyclerViewAdapter.OnItemLongClickListener,
        RecyclerViewAdapter.OnItemClickListener,
        DataChangeObserver {

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
        mRecyclerAdapter.setOnItemClickListener(this);// 设置点击事件监听
        mRecyclerAdapter.setOnItemLongClickListener(this);// 设置长按事件监听
        DataChangeSubject.getInstance().registerObserver(this);// 注册成为观察者
    }

    @Override
    protected void bindViewAndData() {

    }

    /**
     * 设置数据
     */
    private void setData() {
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

    private void showPopupWindow(View view, ContactInfo contactInfo) {
        ContactMenu contactMenu = new ContactMenu(mContext, contactInfo);
        View contentView = contactMenu.getRootView();
        final PopupWindow popupWindow = new PopupWindow(contentView, view.getWidth() - UIUtils.dip2Px(20), WindowManager.LayoutParams.WRAP_CONTENT);
        //设置背景颜色,必须加这个背景,否则点击外部无法取消
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置能拿到焦点,是为了点击外面能够取消,并且不会打开新的popupwindow
        popupWindow.setFocusable(true);
        //显示popupWindow
        popupWindow.showAsDropDown(view, UIUtils.dip2Px(10), -view.getHeight() + UIUtils.dip2Px(50));
        contactMenu.setOnItemClickListener(new ContactMenu.OnItemClickListener() {
            @Override
            public void onItemClick() {
                popupWindow.dismiss();
            }
        });
    }


    @Override
    public void onItemClick(View view, int position) {
        showPopupWindow(view, mDatas.get(position));
    }

    @Override
    public void onItemLongClick(View view, int position) {
        ContactUtil.callPhone(mDatas.get(position).getNumber());
    }
}
