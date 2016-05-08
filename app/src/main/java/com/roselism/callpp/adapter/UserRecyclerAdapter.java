package com.roselism.callpp.adapter;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roselism.callpp.R;

import java.util.List;

import butterknife.Bind;

/**
 * @创建者 lai
 * @创建时间 2016/5/7
 * @packageName com.roselism.callpp.adapter.viewholder
 * @更新时间 2016/5/7 23:03
 * @描述 用户设置中的RecyclerAdapter的Adapter
 */
public class UserRecyclerAdapter extends RecyclerViewAdapter<String> {
    public UserRecyclerAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    protected ViewHolder getNormalViewHolder(ViewGroup parent) {
        return new UserViewHolder(parent);
    }


     class UserViewHolder extends RecyclerViewAdapter.ViewHolder {
        @Bind(R.id.user_item_icon)  ImageView mUserItemIcon;
        @Bind(R.id.user_item_title) TextView  mUserItemTitle;

        public UserViewHolder(ViewGroup parent) {
            super(R.layout.item_recycler_user, parent);
        }

        @Override
        public void bindData(int position) {
            mUserItemTitle.setText(mDatas.get(position));
        }
    }
}
