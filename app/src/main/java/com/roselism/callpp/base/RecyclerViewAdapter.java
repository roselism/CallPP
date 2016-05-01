package com.roselism.callpp.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.roselism.callpp.util.UIUtils;

import java.util.List;

import butterknife.ButterKnife;

/**
 * @创建者 lai
 * @创建时间 2016/4/30
 * @packageName com.roselism.callpp.adapter
 * @更新时间 2016/4/30 19:49
 * @描述 主页面中RecyclerView的Adapter
 * @param <T>
 *            显示的数据类型
 */
public abstract class RecyclerViewAdapter<T> extends RecyclerView.Adapter {

	protected Context mContext = UIUtils.getContext();
	protected List<T> mDatas;
	protected OnItemClickListener mItemClickListener;// 点击监听
	protected OnItemLongClickListener mItemLongClickListener;// 长按监听

	public RecyclerViewAdapter(List<T> datas) {
		mDatas = datas;
	}

	/**
	 * 给条目设置点击监听
	 * 
	 * @param itemClickListener
	 *            点击监听回调接口
	 */
	public void setOnItemClickListener(OnItemClickListener itemClickListener) {
		mItemClickListener = itemClickListener;
	}

	/**
	 * 给条目设置长按监听
	 * 
	 * @param itemLongClickListener
	 *            长按监听回调接口
	 */
	public void setOnLongClickListener(
			OnItemLongClickListener itemLongClickListener) {
		mItemLongClickListener = itemLongClickListener;
	}

	@Override
	public int getItemCount() {
		if (mDatas != null)
			return mDatas.size();
		return 0;
	}

	public interface OnItemClickListener {
		void onItemClick(View view, int position);
	}

	public interface OnItemLongClickListener {
		void onItemClick(View view, int position);
	}

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			if (mItemClickListener != null) {
				mItemClickListener.onItemClick(v, getAdapterPosition());
			}
		}
	}
}
