package com.roselism.callpp.model.engine.stragegy.query;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.model.domain.dust.BmobBaseUser;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.Stragegy;

import cn.bmob.v3.listener.SaveListener;

/**
 * 用户登录测略
 * Created by simon on 16-5-4.
 */
public class UserBmobLoginStragegy implements Stragegy<BmobBaseUser> {

    BmobBaseUser bmobBaseUser;

    public UserBmobLoginStragegy(BmobBaseUser bmobBaseUser) {
        this.bmobBaseUser = bmobBaseUser;
    }

    @Override
    public void run(final OnOperatListener<BmobBaseUser> listener) {
        bmobBaseUser.login(CallppApplication.getContext(), new SaveListener() {
            @Override
            public void onSuccess() {
                listener.onSuccedd(bmobBaseUser);
            }

            @Override
            public void onFailure(int i, String s) {
                listener.onError(new Throwable("i:" + i + " s:" + s));
            }
        });
    }
}
