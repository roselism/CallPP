package com.roselism.callpp.adapter.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.roselism.callpp.R;
import com.roselism.callpp.local.bean.ContactInfo;
import com.roselism.callpp.util.ContactUtil;
import com.roselism.callpp.view.ContactMenuItemView;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/5/3 1:05
 * @描述 联系人弹出的对话框的列表
 */
public class ContactMenu extends BaseViewHolder implements View.OnClickListener {
    private final ContactInfo         mContactInfo;
    private       ContactMenuItemView mContactMenuCall;
    private       ContactMenuItemView mContactMenuEdit;
    private       OnItemClickListener mListener;

    public ContactMenu(Context context, ContactInfo contactInfo) {
        super(context);
        mContactInfo = contactInfo;
    }

    @Override
    protected View initRootView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.menu_contact, null);
        mContactMenuCall = (ContactMenuItemView) view.findViewById(R.id.contact_menu_call);
        mContactMenuEdit = (ContactMenuItemView) view.findViewById(R.id.contact_menu_edit);
        return view;
    }


    @Override
    protected void initListener() {
        mContactMenuCall.setOnClickListener(this);
        mContactMenuEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.contact_menu_call:
                ContactUtil.callPhone(mContactInfo.getNumber());
                break;
            case R.id.contact_menu_edit:

                break;
            default:
                break;
        }
        mListener.onItemClick();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick();
    }

}
