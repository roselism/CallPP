package com.roselism.callpp.model.engine.stragegy.query.bmob;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.Stragegy;

import cn.bmob.v3.listener.SaveListener;

/**
 * 用户登录测略
 * Created by simon on 16-5-4.
 */
public class UserLoginStragegy implements Stragegy<User> {

    User user;

    public UserLoginStragegy(User user) {
        this.user = user;
    }

    @Override
    public void run(final OnOperatListener<User> listener) {
        user.login(CallppApplication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() {
                listener.onSuccedd(user);
            }

            @Override
            public void onFailure(int i, String s) {
                listener.onError(new Throwable("i:" + i + " s:" + s));
            }
        });
    }
}
