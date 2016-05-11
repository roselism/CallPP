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
import com.roselism.callpp.domain.BmobBaseUser;
import com.roselism.callpp.util.ConfigUtil;
import com.roselism.callpp.util.LogUtil;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * @author simon wang
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity implements
        View.OnFocusChangeListener, View.OnClickListener {

    private final static int LOGIN_ACTION = 1; // 登陆操作
    private final static int SIGNUP_ACTION = 2; // 注册操作
    public static int flag = 0;
    @Bind(R.id.login_et_email) EditText mloginEtEmail;
    @Bind(R.id.login_et_password) EditText mloginEtPassword;
    @Bind(R.id.login_et_password_again) EditText mloginEtPwdAgain;
    @Bind(R.id.btn_login) Button mbtnLogin;
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
        try {
            Bmob.initialize(this, ConfigUtil.getAppKey("bmob")); // 初始化bmob
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void initEvent() {
        mloginEtPassword.setOnFocusChangeListener(this); // 给password设置焦点监听器
        mbtnLogin.setOnClickListener(this);
    }

    void initData() {
//        Intent intent= new Intent()
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login: // 注册逻辑
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
                    BmobQuery<BmobBaseUser> query = new BmobQuery<>();
                    query.addWhereEqualTo("email", email);
//                    query.addWhereEqualTo("password");q
                    query.findObjects(this, new FindListener<BmobBaseUser>() {
                        @Override
                        public void onSuccess(List<BmobBaseUser> list) {
                            if (list != null && list.size() > 0) {// 该用户已经注册
                                LogUtil.i(list.get(0).toString());
                                showLoginComponent();
                                flag = LOGIN_ACTION;
                            } else { // 该用户还未注册
                                showSignUpComponent();
                                flag = SIGNUP_ACTION;
                            }
                        }

                        @Override
                        public void onError(int i, String s) {
                            Toast.makeText(LoginActivity.this, "有点小问题...", Toast.LENGTH_SHORT).show();
                            LogUtil.i("i = " + i + " s = " + s);
                        }
                    });
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

        String email = mloginEtEmail.getText().toString();
        BmobBaseUser user = new BmobBaseUser();
        user.setEmail(email);
        user.setPassword(pwdAgain);
        user.signUp(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 登陆逻辑
     */
    public void login() {
        String email = mloginEtEmail.getText().toString();
        String password = mloginEtPassword.getText().toString().trim();

        BmobBaseUser user = new BmobBaseUser();
        user.setUsername(email);
        user.setPassword(password);
        user.login(this, new SaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int i, String s) {
                Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
            }
        });

        enterHome();
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
        mbtnLogin.setText(getResources().getString(R.string.login_login_button)); //显示登陆
        mloginEtPwdAgain.setVisibility(View.INVISIBLE); // 二次密码框消失
    }

    /**
     * 显示注册界面的组件
     */
    private void showSignUpComponent() {
        mbtnLogin.setText(getResources().getString(R.string.login_signup_button));
        mloginEtPwdAgain.setVisibility(View.VISIBLE); // 显示二次密码
    }
}
