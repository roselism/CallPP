package com.roselism.callpp.model.domain.filed;

/**
 * 用户的字段名
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/11 09:59
 * @packageName: com.roselism.callpp.model.domain.rose
 */
public interface UserFiled {
    String EMAIL = "email";

    /**
     * 电话号码字段
     */
    String PHONE_NUMBER = "phoneNumber";

    /**
     * 用户头像的url地址
     */
    String PROFILE_URL = "profileUrl";

    /**
     * 用户邮箱是否验证
     */
    String EMAILVERIFIED = "emailVerified";

    /**
     * 用户的昵称
     */
    String NICKNAME = "nickName";

    /**
     * 密码
     */
    String PASSWORD = "password";
}
