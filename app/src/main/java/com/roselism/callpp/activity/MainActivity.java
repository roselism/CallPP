package com.roselism.callpp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.roselism.callpp.R;
import com.roselism.callpp.adapter.ContentPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    @Bind(R.id.main_rg_toolbar) RadioGroup mRgToolbar;
    @Bind(R.id.main_viewpager_content) ViewPager mViewpagerContent;

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
        mViewpagerContent.addOnPageChangeListener(this);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mViewpagerContent.setAdapter(new ContentPagerAdapter(this, mRgToolbar.getChildCount()));
    }

    /**
     * 把RadioButton的ID转换成索引
     *
     * @param rbId 要转换的ID
     * @return RadioButton相对Toolbar的索引
     */
    private int rbId2Index(int rbId) {
        switch (rbId) {
            case R.id.main_rb_toolbar_home:
                return 0;
            case R.id.main_rb_toolbar_user:
                return 1;
            default:
                throw new RuntimeException("点击Toolbar时出现错误");
        }
    }

    /**
     * 把索引转换成RadioButton的ID
     *
     * @param index 要转换的索引
     * @return RadioButton的ID
     */
    private int index2RbId(int index) {
        switch (index) {
            case 0:
                return R.id.main_rb_toolbar_home;
            case 1:
                return R.id.main_rb_toolbar_user;
            default:
                throw new RuntimeException("没有找到对应的RadioButton");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        mViewpagerContent.setCurrentItem(rbId2Index(checkedId));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        mRgToolbar.check(index2RbId(position));
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
