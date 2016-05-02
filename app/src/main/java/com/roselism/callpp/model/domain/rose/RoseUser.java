package com.roselism.callpp.model.domain.rose;

import android.widget.Toast;

import com.roselism.callpp.CallppAPPlication;
import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.util.LogUtil;
import com.roselism.callpp.util.convert.Converter;
import com.roselism.callpp.util.convert.RoseUser2BmobUser;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by simon on 2016/4/30.
 */
public class RoseUser extends RoseObject {

    /**
     * 用户邮箱
     */
    String email;

    /**
     * 用户密码
     */
    String password;

    /**
     * 用户头像的url地址
     */
    String profileUrl;

    public RoseUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void save(final OnSaveListener<? extends RoseObject> listener) {
        // 存储策略 - bmob对象的存储
        Converter<RoseUser, User> converter = new RoseUser2BmobUser();
        final User user = converter.convert(this);
        user.signUp(CallppAPPlication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() {
                listener.onFinish();
            }

            @Override
            public void onFailure(int i, String s) {
                LogUtil.e("i:" + s);
                listener.onError();
            }
        });
    }

    /**
     * 用户的登陆逻辑
     */
    public void login(final OnOperatListener<Boolean> listener) {
        Converter<RoseUser, User> converter = new RoseUser2BmobUser();
        final User user = converter.convert(this);

        // bmob user 的登陆逻辑
        user.login(CallppAPPlication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() { //登陆成功
                Toast.makeText(CallppAPPlication.getContext(), "登陆成功", Toast.LENGTH_SHORT).show(); // 登陆成功
                listener.onSuccedd(true);
            }

            @Override
            public void onFailure(int i, String s) { // 登陆失败
                Toast.makeText(CallppAPPlication.getContext(), "登陆失败", Toast.LENGTH_SHORT).show(); // 登陆成功
//                listener.onError(i + " " + s););
                listener.onSuccedd(false);
//                Log.i(TAG, "onFailure: ");
                LogUtil.e(i + " " + s);
            }
        });
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}