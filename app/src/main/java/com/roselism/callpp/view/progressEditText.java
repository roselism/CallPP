package com.roselism.callpp.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.roselism.callpp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 带有进度条的EidtText
 * Created by simon on 2016/5/1.
 */
public class ProgressEditText extends EditText {

    @Bind(R.id.edittext) EditText mEdittext;
    @Bind(R.id.progress) ProgressBar mProgress;

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
        View view = View.inflate(getContext(), R.layout.view_progress_edittext, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}