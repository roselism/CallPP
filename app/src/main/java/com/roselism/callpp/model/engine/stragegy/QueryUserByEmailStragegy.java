package com.roselism.callpp.model.engine.stragegy;

import android.content.Context;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseUser;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by simon on 2016/4/30.
 */
public class QueryUserByEmailStragegy implements Stragegy<RoseUser> {

    String email;
    Context context;

    public QueryUserByEmailStragegy(String email) {
        this.email = email;
    }

    /**
     * 查询到Bmobuser的对象，且自行转换成RoseUser对象
     *
     * @param listener
     */
    @Override
    public void run(final OnOperatListener<RoseUser> listener) {
        BmobQuery<User> query = new BmobQuery<>();
        query.addWhereEqualTo("email", email);
        query.findObjects(context, new FindListener<User>() {
            @Override
            public void onSuccess(List<User> list) {
                User user = list.get(0);
                RoseUser roseUser = new RoseUser(user);
                listener.onSuccedd(roseUser);
            }

            @Override
            public void onError(int i, String s) {
                listener.onError(new Exception(i + "" + s));
            }
        });
    }
}