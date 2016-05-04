package com.roselism.callpp.model.engine;

/**
 * 具体策略
 * 根据用户的email来查询user的命令
 * Created by simon on 2016/4/30.
 */
public class QueryUserByEmailCommand implements Command {

    QueryUserReceiver receiver;
    String email;

    /**
     * @param receiver 命令接收者
     * @param email    要被查询的邮箱
     */
    public QueryUserByEmailCommand(QueryUserReceiver receiver, String email) {
        this.receiver = receiver;
        this.email = email;
    }
    
    @Override
    public void excute() {
        if (email == null)
            throw new NullPointerException("邮箱地址不能为null");

        receiver.queryUserByEmail(email);
    }
}