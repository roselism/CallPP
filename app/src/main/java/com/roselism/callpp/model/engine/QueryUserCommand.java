package com.roselism.callpp.model.engine;

import com.roselism.callpp.model.domain.rose.RoseUser;

/**
 * 查询根据用户提供的信息，在服务器上是否存在这个用户
 * 比如用户提供了email 和password 就可以用来查询这个用户是否合法
 * Created by simon on 16-5-4.
 */
public class QueryUserCommand implements Command {

    RoseUser user;
    QueryUserReceiver receiver;

    /**
     * 根据用户所携带；的信息来查询用户是否存在
     *
     * @param user     要被查询的用户
     * @param receiver 命令接受者
     */
    public QueryUserCommand(RoseUser user, QueryUserReceiver receiver) {
        this.user = user;
        this.receiver = receiver;
    }

    @Override
    public void excute() {

    }
}
