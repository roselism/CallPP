package com.roselism.callpp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.roselism.callpp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.login_et_email) EditText mloginEtEmail;
    @Bind(R.id.login_et_password) EditText mloginEtPassword;
    @Bind(R.id.login_et_password_again) EditText mloginEtPwdAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
}