package com.roselism.callpp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.roselism.callpp.R;
import com.roselism.callpp.model.engine.Command;
import com.roselism.callpp.model.engine.QueryUserByEmailCommand;
import com.roselism.callpp.model.engine.QueryUserReceiver;
import com.roselism.callpp.model.engine.Sender;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener {

    @Bind(R.id.login_et_email) EditText mloginEtEmail;
    @Bind(R.id.login_et_password) EditText mloginEtPassword;
    @Bind(R.id.login_et_password_again) EditText mloginEtPwdAgain;

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
    }

    void initEvent() {
        mloginEtPassword.setOnFocusChangeListener(this); // 给password设置焦点监听器
    }

    void initData() {

    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.login_et_email:
                if (hasFocus) { // 当前email获取焦点

                }
                break;

            case R.id.login_et_password: // password 框获取焦点
                if (hasFocus) {
                    String email = mloginEtEmail.getText().toString().trim(); // 用户输入的邮箱地址

                    // xiefa
                    QueryUserReceiver receiver = new QueryUserReceiver(new OnOperatListener() {
                        @Override
                        public void onSuccedd(Object t) {

                        }

                        @Override
                        public void onError(Throwable error) {

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
}

