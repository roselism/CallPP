package com.roselism.callpp.adapter;

import android.content.Context;
import android.widget.TextView;

import com.roselism.callpp.adapter.viewholder.BaseViewHolder;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 15:22
 * @描述 TODO
 * @deprecated 由于ListView 替换成RecyclerView所以该类弃用
 */
@Deprecated
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
