package com.roselism.callpp.activity;

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
    @Bind(R.id.profile) ImageView profile;

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
                if (hasFocus) { // 当前email获取焦点

                }
                break;

            case R.id.login_et_password: // password 框获取焦点

                String email = mloginEtEmail.getText().toString().trim(); // 用户输入的邮箱地址

                if (hasFocus && email != null && email.trim().length() > 0) {
                    QueryUserReceiver receiver = new QueryUserReceiver(new OnOperatListener<RoseUser>() {
                        @Override
                        public void onSuccedd(RoseUser user) { // 查有此人
                            if (user != null) { // 该用户已经注册
                                LogUtil.i(user.toString());
                                showLoginComponent();
                                flag = LOGIN_ACTION;
                            } else { // 该用户还未注册
                                showSignUpComponent();
                                flag = SIGNUP_ACTION;
                            }
                        }

                        @Override
                        public void onError(Throwable error) {
                            Toast.makeText(LoginActivity.this, "有点小问题...", Toast.LENGTH_SHORT).show();
                        }
                    });
                    Command command = new QueryUserByEmailCommand(receiver, email);
                    Sender sender = new Sender();
                    sender.setCommand(command);
                    sender.send();
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

    }

    /**
     * 显示登陆逻辑的组件
     */
    private void showLoginComponent() {
        mLoginButton.setText(getResources().getString(R.string.login_login_button)); //显示登陆
    }

    /**
     * 显示注册界面的组件
     */
    private void showSignUpComponent() {
        mLoginButton.setText(getResources().getString(R.string.login_signup_button));
        mloginEtPwdAgain.setVisibility(View.VISIBLE); // 显示二次密码
    }


}