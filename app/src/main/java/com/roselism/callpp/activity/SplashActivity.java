package com.roselism.callpp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.roselism.callpp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.bg_image) ImageView mBgImage;
    @Bind(R.id.splash_tv_versionname) TextView mSplashTvVersionname;
    @Bind(R.id.splash_progress_loading) ProgressBar mSplashProgressLoading;

    // json
    //{"versionCode":"1", "versionName":"1.52.52","desc":"新增NB功能，赶快下载","downloadLink":"www.asdjfiosdf.sdfasd"}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);


    }

    /**
     * 读取
     * @return
     */
    protected String readVersionName() {

    }

    protected String readVersionCode() {

    }

    /**
     * 读取服务器端的版本名字
     */
    void readServerVersionName() {

    }

    /**
     * 读取服务器端的版本号
     */
    void readServerVersionCode() {

    }
}