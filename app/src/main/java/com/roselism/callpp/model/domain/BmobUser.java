package com.roselism.callpp.model.domain;

import com.roselism.callpp.model.domain.adapter.BmobIBOAdapter;

/**
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 12:26
 * @packageName: com.roselism.callpp.model.domain.bmob
 */
public class BmobUser extends BmobIBOAdapter {

    /**
     * 邮箱
     */
    String email;

    /**
     * 密码
     */
    String password;

    /**
     * 用户的电话
     */
    String phoneNumber;

    /**
     * 用户头像的url地址
     */
    String profileUrl;

    /**
     * 用户邮箱是否验证
     */
    boolean emailVerified;

    /**
     * 用户的昵称
     */
    String nickName;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getCreateDate() {
        return null;
    }
}
