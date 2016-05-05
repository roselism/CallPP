package com.roselism.callpp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import com.roselism.callpp.util.convert.InStream2OutStream;
import com.roselism.callpp.util.convert.InStream2String;
import com.roselism.callpp.util.net.HttpConnectionHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    private final static int CODE_ENTER_HOME = 1; // 进入主界面
    private final static int CODE_JSON_ERROR = 2; // json解析错误
    private final static int CODE_IO_ERROR = 3; //
    private final static int CODE_READ_FINISHED = 4; // 读取完毕

    @Bind(R.id.bg_image) ImageView mBgImage;
    @Bind(R.id.splash_tv_versionname) TextView mSplashTvVersionname;
    @Bind(R.id.splash_progress_loading) ProgressBar mSplashProgressLoading;//

    private int serverVersionCode; // 版本号
    private String serverVersionName; // 版本名字
    private String downloadUrl; // 下载url
    private String desc; //新版本描述

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            // 到达这里一定是程序已经运行了两秒之后的
            switch (msg.what) {
                case CODE_ENTER_HOME: // 进入主界面
                    enterHome();
                    break;
                case CODE_JSON_ERROR: // json 解析错误
                    enterHome();
                    break;
                case CODE_IO_ERROR: // 网络链接错误
                    enterHome();
                    break;
                case CODE_READ_FINISHED: // 读取完毕
                    checkUpdate();
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
        builder.setTitle("发现新版本" + serverVersionName).
                setMessage(desc).
                setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { // 开始下载
                        try {
                            download();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).
                setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        enterHome(); // 取消时进入home
                    }
                }).
                setNegativeButton("一会儿再说", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        enterHome(); // 进入主页
                    }
                }).show();
    }

    /**
     * 开始下载
     *
     * @throws IOException
     */
    private void download() throws IOException {
        HttpConnectionHelper.Builder builder = new HttpConnectionHelper.Builder();
        HttpConnectionHelper helper = builder.setPath(downloadUrl).build();

        File out = new File(getFilesDir(), serverVersionName + ".apk");
        InStream2OutStream convert = new InStream2OutStream(out); // 输入输出流互考
        convert.convert(helper.getConnection().getInputStream());

        // 跳转到系统下载页面
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setDataAndType(Uri.fromFile(out), "application/vnd.android.package-archive");
        // startActivity(intent);
        startActivityForResult(intent, 0);// 如果用户取消安装的话,会返回结果,回调方法onActivityResult
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        enterHome();
    }

    /**
     * 初始化view
     */
    void initView() {
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        readServerVersionInfo();
        LogUtil.i("initview");
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
        if (serverVersionCode > readVersionCode()) { // 有更新版本
            buildDialog(); // 创建一个dialog
        } else { // 当前版本号与服务器相同，直接进入主界面
            enterHome();
        }
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
     * 读取服务器端的版本信息
     */
    void readServerVersionInfo() {

        LogUtil.i("readServerVersionInfo");
        final long startTime = System.currentTimeMillis();
        new Thread() {
            @Override
            public void run() {
                LogUtil.i("run");
                Message msg = mHandler.obtainMessage();
                String url = "url";
                HttpConnectionHelper.Builder builder = new HttpConnectionHelper.Builder();
                HttpConnectionHelper helper = builder.setPath(url).build(); // url
                try {
                    if (helper.isResponseOk()) { // 回应200 链接正常
                        parseJson(helper); // 解析Json数据
                        msg.what = CODE_READ_FINISHED;
                    } else { // 回应其他 what设置为进入主界面
                        LogUtil.i(helper.responseCode() + "");
                        msg.what = CODE_ENTER_HOME;
                    }
                } catch (IOException e) { // 网络连接错误
                    msg.what = CODE_IO_ERROR;
                    e.printStackTrace();
                } catch (JSONException e) { // json 解析错误
                    msg.what = CODE_JSON_ERROR;
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

            /**
             * 解析 从网络得到的json数据
             * @param helper 网络链接帮助器
             * @throws IOException
             * @throws JSONException
             */
            private void parseJson(HttpConnectionHelper helper) throws IOException, JSONException {
                InStream2String inStream2String = new InStream2String(); // 声明一个转换器
                String context = inStream2String.convert(helper.getConnection().getInputStream()); // 转换成String
                JSONObject jsonObject = new JSONObject(context); // json解析对象

                serverVersionName = jsonObject.getString("versionName"); // 版本名
                serverVersionCode = jsonObject.getInt("versionCode"); // 版本号
                desc = jsonObject.getString("desc"); // 版本描述
                downloadUrl = jsonObject.getString("downloadLink"); // 下载链接
            }
        }.start();
    }
}