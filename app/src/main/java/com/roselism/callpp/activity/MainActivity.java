package com.roselism.callpp.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.roselism.callpp.R;
import com.roselism.callpp.fragment.HomeFragment;
import com.roselism.callpp.fragment.UserFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
		implements
			RadioGroup.OnCheckedChangeListener {

	private static final String HOME = "home";
	private static final String USER = "user";
	@Bind(R.id.main_rb_toolbar_home)
	RadioButton mRbToolbarHome;
	@Bind(R.id.main_rb_toolbar_user)
	RadioButton mRbToolbarUser;
	@Bind(R.id.main_rg_toolbar)
	RadioGroup  mRgToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		initListener();
		initFragment();
		initData();
	}

	/**
	 * 设置监听
	 */
	private void initListener() {
		mRgToolbar.setOnCheckedChangeListener(this);
	}

	/**
	 * 初始化界面
	 */
	private void initFragment() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		transaction.add(new HomeFragment(), HOME);
		transaction.add(new UserFragment(),USER);
	}
	/**
	 * 初始化数据
	 */
	private void initData() {

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
			case R.id.main_rb_toolbar_home :

				break;
			case R.id.main_rb_toolbar_user :

				break;
			default :
				throw new RuntimeException("点击Toolbar时出现错误");
		}
	}
}
