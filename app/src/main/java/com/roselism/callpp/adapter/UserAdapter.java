package com.roselism.callpp.adapter;

import android.content.Context;
import android.widget.TextView;

import com.roselism.callpp.base.BaseViewHolder;
import com.roselism.callpp.base.SuperBaseAdapter;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 15:22
 * @描述 TODO
 */
public class UserAdapter extends SuperBaseAdapter<UserAdapter.ViewHolder,String> {

    public UserAdapter(Context context, List<String> data) {
        super(context, data);
    }

    @Override
    protected void bindData(ViewHolder holder, int position) {
        holder.getRootView().setText(mData.get(position));
    }

    @Override
    protected ViewHolder initViewHolder() {
        return new ViewHolder(mContext);
    }

    /**
     * ListView的viewholder
     */
    static class ViewHolder extends BaseViewHolder<TextView,String>{

        public ViewHolder(Context context) {
            super(context);
        }

        @Override
        protected TextView initRootView() {
            return new TextView(mContext);
        }
    }
}
