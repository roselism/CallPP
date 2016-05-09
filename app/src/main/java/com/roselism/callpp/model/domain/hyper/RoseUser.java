package com.roselism.callpp.model.domain.hyper;

import com.roselism.callpp.model.domain.Baas;

/**
 * 修正抽象角色
 * 抽象修正角色都以Rose为开头
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 13:14
 * @packageName: com.roselism.callpp.model.domain
 */
public abstract class RoseUser extends Rose {
    public RoseUser(Baas baas) {
        super(baas);
    }

    /**
     * 抽象实现者对象
     */
//    protected Baas mBaas;

    /**
     * 创建一个抽象bean
     *
     * @param baas
     */
//    public RoseUser(Baas baas) {
////        this.mBaas = baas;
//
//    }

    /**
     * 获取用户邮箱是否验证
     *
     * @return
     */
    boolean isEmailVerified() {
        return false;
    }

    /**
     * 设置用户邮箱验证
     *
     * @param emailVerified
     */
    abstract void setEmailVerified(boolean emailVerified);

    /**
     * 获取用户的昵称
     *
     * @return
     */
    abstract String getNickName();

    /**
     * 设置用户昵称
     *
     * @param nickName
     */
    abstract void setNickName(String nickName);

    /**
     * 获取用户的email
     *
     * @return
     */
    abstract String getEmail();

    /**
     * 设置用户的email
     *
     * @param email
     */
    abstract void setEmail(String email);

    /**
     * 获取用户的密码
     *
     * @return
     */
    abstract String getPassword();

    /**
     * 设置密码
     *
     * @param password
     */
    abstract void setPassword(String password);

    /**
     * 设置用户的电话号码
     *
     * @return
     */
    abstract String getPhoneNumber();

    /**
     * 设置电话号码
     *
     * @param phoneNumber
     */
    abstract void setPhoneNumber(String phoneNumber);

    /**
     * 获取用户头像url
     *
     * @return
     */
    abstract String getProfileUrl();

    /**
     * 设置用户头像url
     *
     * @param profileUrl
     */
    abstract void setProfileUrl(String profileUrl);

    /**
     * 登陆逻辑
     */
    public void login() {
        mbaas.query(new Baas.QueryListener() { // 查询用户是否存在
            @Override
            public void onQuery(Object o) {

            }
        });
    }

    /**
     * 注册逻辑
     */
    public void signUp() {
        mbaas.query(new Baas.QueryListener() { // 先查询用户是否存在
            @Override
            public void onQuery(Object o) { // 如果不存在则进行注册，存在则返回提示

            }
        });
    }
}
