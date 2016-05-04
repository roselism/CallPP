package com.roselism.callpp.model.engine.stragegy.query.bmob;

import android.text.TextUtils;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.Stragegy;

import cn.bmob.v3.BmobQuery;

/**
 * 根据用户提供的信息查询用户是否存在
 * Created by simon on 16-5-4.
 */
public class QueryUserByInfoStragegy implements Stragegy<User> {
    private User user;

    public QueryUserByInfoStragegy(User user) {
        this.user = user;
    }

    @Override
    public void run(OnOperatListener<User> listener) {
        BmobQuery<User> query = new BmobQuery<>();
        if (!TextUtils.isEmpty(user.getEmail())) {
            query.addWhereEqualTo("email", user.getEmail());
        }
        if (!TextUtils.isEmpty(user.getObjectId())) {
            query.addWhereEqualTo("objectId", user.getObjectId());
        }
        if (!TextUtils.isEmpty(user.getUsername())) {
            query.addWhereEqualTo("username", user.getUsername());
        }
        if (!TextUtils.isEmpty(user.getEmail())) {

        }
    }
}
