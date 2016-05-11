package com.roselism.callpp.model.engine.stragegy;

import android.content.Context;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.model.domain.dust.RoseUser;
//import com.roselism.callpp.model.abs.RoseUser;

/**
 * 查询用户的具体策略
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/07 22:00
 * @packageName: com.roselism.callpp.model.engine.stragegy
 */
public abstract class QueryUserStragegy implements QueryStragegy {

    protected RoseUser mUser; // 要被查询的user对象
    protected Context mContext; // 上下文对象

    public QueryUserStragegy(RoseUser roseUser) {
        this.mUser = roseUser;
        mContext = CallppApplication.getContext();
    }

    public QueryUserStragegy(RoseUser mUser, Context mContext) {
        this.mUser = mUser;
        this.mContext = mContext;
    }

    protected QueryUserStragegy() {
    }
}
