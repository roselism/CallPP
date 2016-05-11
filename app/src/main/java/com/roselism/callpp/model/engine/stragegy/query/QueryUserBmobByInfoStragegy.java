package com.roselism.callpp.model.engine.stragegy.query;

import android.text.TextUtils;

import com.roselism.callpp.model.domain.dust.BmobBaseUser;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.Stragegy;

import cn.bmob.v3.BmobQuery;

/**
 * 根据用户提供的信息查询用户是否存在
 * Created by simon on 16-5-4.
 */
public class QueryUserBmobByInfoStragegy implements Stragegy<BmobBaseUser> {
    private BmobBaseUser bmobBaseUser;

    public QueryUserBmobByInfoStragegy(BmobBaseUser bmobBaseUser) {
        this.bmobBaseUser = bmobBaseUser;
    }

    @Override
    public void run(OnOperatListener<BmobBaseUser> listener) {
        BmobQuery<BmobBaseUser> query = new BmobQuery<>();
        if (!TextUtils.isEmpty(bmobBaseUser.getEmail())) {
            query.addWhereEqualTo("email", bmobBaseUser.getEmail());
        }
        if (!TextUtils.isEmpty(bmobBaseUser.getObjectId())) {
            query.addWhereEqualTo("objectId", bmobBaseUser.getObjectId());
        }
        if (!TextUtils.isEmpty(bmobBaseUser.getUsername())) {
            query.addWhereEqualTo("username", bmobBaseUser.getUsername());
        }
        if (!TextUtils.isEmpty(bmobBaseUser.getEmail())) {

        }
    }
}
