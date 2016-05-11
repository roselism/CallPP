package com.roselism.callpp.model.engine.stragegy.query;

import android.content.Context;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.model.baas.Baas;
import com.roselism.callpp.model.domain.dust.BmobBaseUser;
import com.roselism.callpp.model.domain.dust.RoseUser;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.QueryUserStragegy;
import com.roselism.callpp.model.engine.stragegy.Stragegy;
import com.roselism.callpp.util.LogUtil;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * 查询bmob下的某个用户
 * Created by simon on 2016/4/30.
 */
public class QueryUserBmobByEmailStragegy extends QueryUserStragegy implements Stragegy<BmobBaseUser> {

    String email;
    Context mContext;

    /**
     * @param email
     * @Deprecated 不在使用，请使用QueryUserBmobByEmailStragegy(RoseUser mUser) 替代
     */
    public QueryUserBmobByEmailStragegy(String email) {
        this.email = email;
        mContext = CallppApplication.getContext();
    }

    public QueryUserBmobByEmailStragegy(RoseUser roseUser) {
        super(roseUser);
    }

    /**
     * 查询到Bmobuser的对象，且自行转换成RoseUser对象
     *
     * @param listener
     */
    @Override
    public void run(final OnOperatListener<BmobBaseUser> listener) {
        BmobQuery<BmobBaseUser> query = new BmobQuery<>();
        query.addWhereEqualTo("email", email);
        query.findObjects(mContext, new FindListener<BmobBaseUser>() {
            @Override
            public void onSuccess(List<BmobBaseUser> list) {
                LogUtil.i("list.size = " + list.size() + "");

                BmobBaseUser bmobBaseUser = null;
                if (list != null && list.size() > 0) { // 查询成功且有数据
                    bmobBaseUser = list.get(0);
                } else { // 查询成功但是无数据
                    bmobBaseUser = null; // 如果没有这个用户的话就赋值为null
                }
                listener.onSuccedd(bmobBaseUser);
            }

            @Override
            public void onError(int i, String s) {
                LogUtil.e(i + "" + s);
                listener.onError(new Exception(i + "" + s));
            }
        });
    }


    @Override
    public void query(Baas.QueryListener listener) {

    }
}