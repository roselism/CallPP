package com.roselism.callpp.model.engine.stragegy;

import android.content.Context;

import com.roselism.callpp.CallppAosdfplication;
import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.util.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by simon on 2016/4/30.
 */
public class QueryUserByEmailStragegy implements Stragegy<User> {

    String email;
    Context mContext;

    public QueryUserByEmailStragegy(String email) {
        this.email = email;
        mContext = CallppAosdfplication.getContext();
    }

    /**
     * 查询到Bmobuser的对象，且自行转换成RoseUser对象
     *
     * @param listener
     */
    @Override
    public void run(final OnOperatListener<User> listener) {
        BmobQuery<User> query = new BmobQuery<>();
        query.addWhereEqualTo("email", email);
        query.findObjects(mContext, new FindListener<User>() {
            @Override
            public void onSuccess(List<User> list) {
                LogUtil.i("list.size = " + list.size() + "");

                User user = null;
                if (list != null && list.size() > 0) { // 查询成功且有数据
                    user = list.get(0);
                } else { // 查询成功但是无数据
                    user = null; // 如果没有这个用户的话就赋值为null
                }
                listener.onSuccedd(user);
            }

            @Override
            public void onError(int i, String s) {
                LogUtil.e(i + "" + s);
                listener.onError(new Exception(i + "" + s));
            }
        });
    }
}