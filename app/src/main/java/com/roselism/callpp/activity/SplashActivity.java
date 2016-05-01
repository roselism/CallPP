package com.roselism.callpp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.roselism.callpp.R;
import com.roselism.callpp.util.LogUtil;
import com.roselism.callpp.util.convert.InStream2String;
import com.roselism.callpp.util.net.HttpConnectionHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    private final static int ENTER_HOME = 1; // 进入主界面
    private final static int CODE_JSON_ERROR = 2; // json解析错误
    private final static int CODE_IO_ERROR = 3; //
    private final static int CODE_READ_FINISHED = 4; // 读取完毕

    @Bind(R.id.bg_image) ImageView mBgImage;
    @Bind(R.id.splash_tv_versionname) TextView mSplashTvVersionname;
    @Bind(R.id.splash_progress_loading) ProgressBar mSplashProgressLoading;

    private int serverVersionCode; // 版本号
    private String serverVersionName; // 版本名字
    private String downloadUrl; // 下载url
    private String desc; //新版本描述

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case ENTER_HOME:
                    break;
                case CODE_JSON_ERROR:
                    break;
                case CODE_IO_ERROR:
                    break;
                case CODE_READ_FINISHED:

                    break;
            }
        }
    };

    // json
    //{"versionCode":"1", "versionName":"1.52.52","desc":"新增NB功能，赶快下载","downloadLink":"www.asdjfiosdf.sdfasd"}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvent();
        initData();
    }

    /**
     * 创一个dialog
     */
    void buildDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("发现新版本" + serverVersionName).setMessage(desc).setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setNegativeButton("一会儿再说", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }

    /**
     * 初始化view
     */
    void initView() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        readServerVersionInfo();
    }

    /**
     * 初始化事件
     */
    void initEvent() {

    }

    /**
     * 初始化数据
     */
    void initData() {

    }

    /**
     * 读取当前app的版本名字
     *
     * @return 如果有则返回当前的版本名字，如果没有，则返回""
     */
    protected String readVersionName() {
        PackageManager manager = getPackageManager();
        String versionName = "";
        try {
            PackageInfo info = manager.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 进入主界面
     */
    public void enterHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 检验是否能够更新
     */
    public void checkUpdate() {

    }

    /**
     * 读取本地的版本号
     *
     * @return 有则返回无则返回-1
     */
    protected int readVersionCode() {
        PackageManager manager = getPackageManager();
        int versionCode = -1;
        try {
            PackageInfo info = manager.getPackageInfo(getPackageName(), PackageManager.GET_ACTIVITIES);
            versionCode = info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * 读取服务器端的版本信息
     */
    void readServerVersionInfo() {

        final long startTime = System.currentTimeMillis();
        new Thread() {
            @Override
            public void run() {
                Message msg = mHandler.obtainMessage();
                HttpConnectionHelper.Builder builder = new HttpConnectionHelper.Builder();
                HttpConnectionHelper helper = builder.setPath("url").build(); // url
                try {
                    if (helper.isResponseOk()) {

                        InStream2String inStream2String = new InStream2String(); // 声明一个转换器
                        String context = inStream2String.convert(helper.getConnection().getInputStream()); // 转换成String
                        JSONObject jsonObject = new JSONObject(context);

                        serverVersionName = jsonObject.getString("versionName"); // 版本名
                        serverVersionCode = jsonObject.getInt("versionCode"); // 版本号
                        desc = jsonObject.getString("desc"); // 版本描述
                        downloadUrl = jsonObject.getString("downloadLink"); // 下载链接

                        msg.what = CODE_READ_FINISHED;
                    } else {
                        LogUtil.i(helper.responseCode() + "");
                    }
                } catch (IOException e) {
                    msg.what = CODE_IO_ERROR;
                    e.printStackTrace();
                    // 网络连接错误
                } catch (JSONException e) {
                    msg.what = CODE_JSON_ERROR;
                    // json 解析错误
                    e.printStackTrace();
                } finally {
                    long endTime = System.currentTimeMillis();
                    long useTime = endTime - startTime;
                    if (useTime < 2000) { // 加载时间小于两秒
                        try {
                            Thread.sleep(2000 - useTime); // 睡够两秒 进行跳转
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    mHandler.sendMessage(msg); // handler 发送message
                }
            }
        }.start();
    }
}