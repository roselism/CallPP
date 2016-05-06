package com.roselism.callpp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.EditText;

import butterknife.ButterKnife;

/**
 * 带有进度条的EidtText
 * Created by simon on 2016/5/1.
 */
public class ProgressEditText extends EditText {


    /**
     * 默认的构造器
     *
     * @param context
     */
    public ProgressEditText(Context context) {
        super(context);
        initView();
    }

    public ProgressEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ProgressEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}