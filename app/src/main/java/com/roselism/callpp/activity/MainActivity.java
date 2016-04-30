package com.roselism.callpp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.roselism.callpp.R;
import com.roselism.callpp.adapter.ContentPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.main_rg_toolbar)        RadioGroup mRgToolbar;
    @Bind(R.id.main_viewpager_content) ViewPager  mViewpagerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
        initData();
    }

    /**
     * 设置监听
     */
    private void initListener() {
        mRgToolbar.setOnCheckedChangeListener(this);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mViewpagerContent.setAdapter(new ContentPagerAdapter(this, mRgToolbar.getChildCount()));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.main_rb_toolbar_home:
                mViewpagerContent.setCurrentItem(0);
                break;
            case R.id.main_rb_toolbar_user:
                mViewpagerContent.setCurrentItem(1);
                break;
            default:
                throw new RuntimeException("点击Toolbar时出现错误");
        }
    }
}
