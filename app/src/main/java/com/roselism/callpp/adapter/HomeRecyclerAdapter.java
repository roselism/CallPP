package com.roselism.callpp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roselism.callpp.R;
import com.roselism.callpp.base.RecyclerViewAdapter;
import com.roselism.callpp.util.UIUtils;

import java.util.List;

import butterknife.Bind;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 22:41
 * @描述 首页的RecyclerView的适配器
 */
public class HomeRecyclerAdapter extends RecyclerViewAdapter<String> {
    public HomeRecyclerAdapter(List<String> datas) {
        super(datas);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_home, parent, false);
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        HomeViewHolder viewHolder = (HomeViewHolder) holder;
        viewHolder.mPhoneNumber.setText(mDatas.get(position));
        viewHolder.mPhoto.setImageResource(R.mipmap.profile2);
    }

    public class HomeViewHolder extends RecyclerViewAdapter.ViewHolder implements View.OnLongClickListener {

        @Bind(R.id.main_item_tv_phonenumber) public TextView mPhoneNumber;
        @Bind(R.id.main_item_img_photo) public ImageView mPhoto;

        public HomeViewHolder(View itemView) {
            super(itemView);
            itemView.setOnLongClickListener(this);
            setItemHeight();
        }

        /**
         * 设置Item的高度
         */
        private void setItemHeight() {
            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            layoutParams.width = UIUtils.getScreenSize().x / 3;
            layoutParams.height = UIUtils.getScreenSize().x / 3;
            itemView.setLayoutParams(layoutParams);
        }

        @Override
        public boolean onLongClick(View v) {
            if (mItemLongClickListener != null) {
                mItemLongClickListener.onItemClick(v, getAdapterPosition());
            }
            return true;
        }
    }
}
