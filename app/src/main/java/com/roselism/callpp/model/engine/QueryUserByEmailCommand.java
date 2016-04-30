package com.roselism.callpp.model.engine;

/**
 * 具体策略
 * Created by simon on 2016/4/30.
 */
public class QueryUserByEmailCommand implements Command {

    QueryUserReceiver receiver;
    String email;

    public QueryUserByEmailCommand(QueryUserReceiver receiver) {
        this.receiver = receiver;
    }

    /**
     * @param receiver 接收者
     * @param email    要被查询的邮箱
     */
    public QueryUserByEmailCommand(QueryUserReceiver receiver, String email) {
        this.receiver = receiver;
        this.email = email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void excute() {
        if (email == null)
            throw new NullPointerException("邮箱地址不能为null");

        receiver.queryUserByEmail(email);
    }
}