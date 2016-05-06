package com.roselism.callpp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.roselism.callpp.R;
import com.roselism.callpp.local.bean.ContactInfo;
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
public class HomeRecyclerAdapter extends RecyclerViewAdapter<ContactInfo> {
	public HomeRecyclerAdapter(List<ContactInfo> datas) {
		super(datas);
	}

	@Override
	protected RecyclerView.ViewHolder getViewHolder(ViewGroup parent) {
		return new HomeViewHolder(parent);
	}

	/**
	 * 首页显示联系人的ViewHolder
	 */
	public class HomeViewHolder extends ViewHolder {

		@Bind(R.id.main_item_img_photo)
		ImageView mPhoto;
		@Bind(R.id.main_item_tv_name)
		TextView mTvName;
		@Bind(R.id.main_item_tv_number)
		TextView mTvNumber;

		public HomeViewHolder(ViewGroup parent) {
			super(R.layout.item_recycler_home, parent);
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
		public void bindData(int position) {
			ContactInfo contactInfo = mDatas.get(position);
			mPhoto.setImageBitmap(contactInfo.getPhoto());
			mTvName.setText(contactInfo.getDisplayName());
			mTvNumber.setText(contactInfo.getNumber());
		}

	}
}
