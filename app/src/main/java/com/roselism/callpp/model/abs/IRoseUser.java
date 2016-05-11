package com.roselism.callpp.model.abs;

/**
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/11 22:25
 * @packageName: com.roselism.callpp.model.abs
 */
public interface IRoseUser extends IRose {

    String getEmail();

    void setEmail(String email);

    boolean isEmailVerified();

    void setEmailVerified(boolean emailVerified);

    String getNickName();

    void setNickName(String nickName);

    String getPassword();

    void setPassword(String password);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getProfileUrl();

    void setProfileUrl(String profileUrl);
}
