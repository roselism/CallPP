package com.roselism.callpp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.roselism.callpp.R;

/**
 * @创建者 lai
 * @创建时间 2016/5/8
 * @packageName com.roselism.callpp.view
 * @更新时间 2016/5/8 13:25
 * @描述 TODO
 */
public class ContactMenuItemView extends RelativeLayout {
    private TextView  mContactMenuItemTitle;
    private View      mContactMenuItemDivider;
    private ImageView mContactMenuItemIcon;

    private String   mText;
    private Drawable mIconRes;
    private boolean  isShow;

    public ContactMenuItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initData(context, attrs);
        bindViewAndData();
    }

    /**
     * 初始化控件
     * @param context
     */
    private void initView(Context context) {
        View.inflate(context, R.layout.menu_contact_item, this);
        mContactMenuItemTitle = (TextView) findViewById(R.id.contact_menu_item_title);
        mContactMenuItemDivider = findViewById(R.id.contact_menu_item_divider);
        mContactMenuItemIcon = (ImageView) findViewById(R.id.contact_menu_item_icon);
    }

    /**
     * 初始化数据
     * @param context
     * @param attrs
     */
    private void initData(Context context, AttributeSet attrs) {
        //取出控件里面定义的属性
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ContactMenuItemView);
        mText = ta.getString(R.styleable.ContactMenuItemView_text);
        isShow = ta.getBoolean(R.styleable.ContactMenuItemView_isShow, true);
        mIconRes = ta.getDrawable(R.styleable.ContactMenuItemView_iconRes);
        ta.recycle();//释放资源
    }

    /**
     * 属性和控件绑定
     */
    private void bindViewAndData() {
        mContactMenuItemTitle.setText(mText);
        mContactMenuItemIcon.setImageDrawable(mIconRes);
        if (isShow) {
            mContactMenuItemDivider.setVisibility(View.VISIBLE);
        } else {
            mContactMenuItemDivider.setVisibility(View.GONE);
        }
    }
}
