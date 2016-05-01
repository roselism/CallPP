package com.roselism.callpp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.roselism.callpp.R;
import com.roselism.callpp.model.domain.rose.OnSaveListener;
import com.roselism.callpp.model.domain.rose.RoseUser;
import com.roselism.callpp.model.engine.Command;
import com.roselism.callpp.model.engine.QueryUserByEmailCommand;
import com.roselism.callpp.model.engine.QueryUserReceiver;
import com.roselism.callpp.model.engine.Sender;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.util.LogUtil;
import com.roselism.callpp.util.MatcherUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;

/**
 * @author simon wang
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {

    private final static int LOGIN_ACTION = 1; // 登陆操作
    private final static int SIGNUP_ACTION = 2; // 注册操作
    public static int flag = 0;
    @Bind(R.id.login_et_email) EditText mloginEtEmail;
    @Bind(R.id.login_et_password) EditText mloginEtPassword;
    @Bind(R.id.login_et_password_again) EditText mloginEtPwdAgain;
    @Bind(R.id.login_button) Button mLoginButton;
    @Bind(R.id.profile) ImageView mProfile; // 用户的头像

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initEvent();
        initData();
    }

    void initView() {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        Bmob.initialize(this, "5b3be373e078b301e82d410c7e207e1d"); // 初始化bmob
    }

    void initEvent() {
        mloginEtEmail.setOnFocusChangeListener(this);
        mloginEtPassword.setOnFocusChangeListener(this); // 给password设置焦点监听器
        mLoginButton.setOnClickListener(this);
    }

    void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button: // 注册逻辑
                if (flag == LOGIN_ACTION)
                    login();
                else if (flag == SIGNUP_ACTION)
                    signUp();
                break;
        }
    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.login_et_email:

                String email = mloginEtEmail.getText().toString().trim(); // 用户输入的邮箱地址

                if (hasFocus) { // 当前email获取焦点
                    LogUtil.i("email 输入框获得焦点");
                } else if (email != null) { // 失去焦点， 且email不为null
                    if (MatcherUtil.matchEmail(email)) { // 匹配email
                        // 当email输入框失去焦点时并且email地址不为null 且长度大于0(说明用户输入完成斌且开始输入密码)
                        LogUtil.i("邮箱已经匹配");

                        // 发送一条查询此人的命令
                        QueryUserReceiver receiver = new QueryUserReceiver(new OnOperatListener<RoseUser>() {
                            @Override
                            public void onSuccedd(RoseUser user) { // 查有此人
                                if (user != null) { // 该用户已经注册
                                    LogUtil.i(user.toString() + "已经注册");
                                    showLoginComponent();
                                    flag = LOGIN_ACTION;
                                } else { // 该用户还未注册
                                    showSignUpComponent();
                                    LogUtil.i("还没有注册");
                                    flag = SIGNUP_ACTION;
                                }
                            }

                            @Override
                            public void onError(Throwable error) {
                                Toast.makeText(LoginActivity.this, "有点小问题...", Toast.LENGTH_SHORT).show();
                            }
                        });
                        Command command = new QueryUserByEmailCommand(receiver, email); // 查询该用户
                        Sender sender = new Sender(); // 创建一个命令请求者
                        sender.setCommand(command); // 请求者设置命令
                        sender.send(); // 将命令发出

                        LogUtil.i("email 输入框失去焦点");
                    } else { // 邮箱格式不正确
                        mloginEtEmail.setError("邮箱格式不是很正确");
                    }
                }

                break;

            case R.id.login_et_password: // password 框获取焦点
                if (hasFocus) { // 密码输入框焦点的时候
                    LogUtil.i("password框获得焦点");
                }
                break;
        }
    }

    /**
     * 注册逻辑
     */
    private void signUp() {
        String password = mloginEtPassword.getText().toString().trim();
        String pwdAgain = mloginEtPwdAgain.getText().toString().trim();
        if (!password.equals(pwdAgain)) { // 两次密码不相同
            mloginEtPwdAgain.setError("密码不一致呦");
            return;
        }

        final RoseUser user = new RoseUser();
        String email = mloginEtEmail.getText().toString();
        user.setEmail(email);
        user.setPassword(password);
        user.save(new OnSaveListener<RoseUser>() {
            @Override
            public void onFinish() {
                LogUtil.i(user.getEmail() + "储存成功");
                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError() {
                LogUtil.i(user.getEmail() + "注册失败");
            }
        });
    }

    /**
     * 登陆逻辑
     */
    public void login() {
        String email = mloginEtEmail.getText().toString();
        String password = mloginEtPassword.getText().toString().trim();
        final RoseUser user = new RoseUser();
        user.setEmail(email);
        user.setPassword(password);
        user.login(new OnOperatListener<Boolean>() {
            @Override
            public void onSuccedd(Boolean t) {
                if (t)
                    enterHome();
            }

            @Override
            public void onError(Throwable error) {

            }
        }); // 登陆

    }

    /**
     * 跳转到主界面
     */
    void enterHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 显示登陆逻辑的组件
     */
    private void showLoginComponent() {
        mLoginButton.setText(getResources().getString(R.string.login_login_button)); //显示登陆
        mloginEtPwdAgain.setVisibility(View.INVISIBLE); // 二次密码框消失
    }

    /**
     * 显示注册界面的组件
     */
    private void showSignUpComponent() {
        mLoginButton.setText(getResources().getString(R.string.login_signup_button));
        mloginEtPwdAgain.setVisibility(View.VISIBLE); // 显示二次密码
    }
}