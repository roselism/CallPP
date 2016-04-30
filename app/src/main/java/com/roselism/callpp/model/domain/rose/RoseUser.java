package com.roselism.callpp.model.domain.rose;

import com.roselism.callpp.CallPPApplication;
import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.util.LogUtil;
import com.roselism.callpp.util.convert.Converter;
import com.roselism.callpp.util.convert.RoseUser2BmobUser;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by simon on 2016/4/30.
 */
public class RoseUser extends RoseBO {
    String email;

    public RoseUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public <R> void save(final OnSaveListener<R> listener) {

        // 存储策略 - bmob对象的存储
        Converter<RoseUser, User> converter = new RoseUser2BmobUser();
        final User user = converter.convert(this);
        user.signUp(CallPPApplication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() {
                listener.onFinish((R) user); // 返回储存成功的对象
            }

            @Override
            public void onFailure(int i, String s) {
                LogUtil.e("i:" + s);
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