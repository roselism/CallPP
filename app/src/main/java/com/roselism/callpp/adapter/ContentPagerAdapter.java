package com.roselism.callpp.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.roselism.callpp.base.BaseViewHolder;
import com.roselism.callpp.factory.ViewHolderFactory;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.activity
 * @更新时间 2016/4/30 14:14
 * @描述 TODO
 */
public class ContentPagerAdapter extends PagerAdapter {

    private int     mCount;
    private Context mContext;

    /**
     * @param context 上下文
     * @param count 显示多少页
     */
    public ContentPagerAdapter(Context context, int count) {
        mContext = context;
        mCount = count;
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        BaseViewHolder viewHolder = ViewHolderFactory.CreateViewHolder(mContext, position);
        View view = viewHolder.getRootView();
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
