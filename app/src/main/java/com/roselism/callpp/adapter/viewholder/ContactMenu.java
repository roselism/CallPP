package com.roselism.callpp.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.roselism.callpp.R;
import com.roselism.callpp.local.bean.ContactInfo;
import com.roselism.callpp.util.ContactUtil;

import butterknife.Bind;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.viewholder
 * @更新时间 2016/5/3 1:05
 * @描述 联系人弹出的对话框的列表
 */
public class ContactMenu extends BaseViewHolder implements View.OnClickListener {
    private final                 ContactInfo mContactInfo;
    @Bind(R.id.contact_menu_call) TextView    mContactMenuCall;
    @Bind(R.id.contact_menu_edit) TextView    mContactMenuEdit;

    public ContactMenu(Context context, ContactInfo contactInfo) {
        super(context);
        mContactInfo = contactInfo;
    }

    @Override
    protected View initRootView() {
        return View.inflate(mContext, R.layout.menu_contact, null);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initListener() {
        mContactMenuCall.setOnClickListener(this);
        mContactMenuEdit.setOnClickListener(this);
    }

    @Override
    protected void bindViewAndData() {

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
    }
}
