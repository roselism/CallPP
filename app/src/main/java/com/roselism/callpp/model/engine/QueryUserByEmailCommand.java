package com.roselism.callpp.model.engine;

import com.roselism.callpp.model.engine.stragegy.OnOperatListener;

/**
 * 具体策略
 * Created by simon on 2016/4/30.
 */
public class QueryUserByEmailCommand implements Command {

    QueryUserReceiver receiver;

    public QueryUserByEmailCommand(QueryUserReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void excute() {
        receiver.queryUserByEmail();
    }
}