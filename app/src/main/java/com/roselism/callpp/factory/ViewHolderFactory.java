package com.roselism.callpp.factory;

import android.content.Context;

import com.roselism.callpp.viewholder.HomeViewHolder;
import com.roselism.callpp.viewholder.UserViewHolder;

import com.roselism.callpp.base.BaseViewHolder;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.factory
 * @更新时间 2016/4/30 15:02
 * @描述 TODO
 */
public class ViewHolderFactory {

    public static BaseViewHolder CreateViewHolder(Context context, int index) {
        switch (index) {
            case 0:
                return new HomeViewHolder(context);
            case 1:
                return new UserViewHolder(context);
            default:
                throw new RuntimeException("没有找到该索引");
        }
    }
}
