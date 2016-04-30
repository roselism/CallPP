package com.roselism.callpp.viewholder;

import android.content.Context;
import android.widget.ListView;

import com.roselism.callpp.adapter.UserAdapter;

import com.roselism.callpp.base.BaseViewHolder;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/4/30 14:28
 * @描述 用户设置的ViewHolder
 */
public class UserViewHolder extends BaseViewHolder<ListView, String> {
    public UserViewHolder(Context context) {
        super(context);
    }

    @Override
    protected ListView initRootView() {
        return new ListView(mContext);
    }

    @Override
    protected void initData() {
        ListView listView = getRootView();
        for (int i = 0; i < 100; i++) {
            mDatas.add("第" + i + "条数据");
        }
        listView.setAdapter(new UserAdapter(mContext, mDatas));
    }
}
