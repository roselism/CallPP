package com.roselism.callpp.model.baas;

import com.roselism.callpp.model.domain.adapter.BmobIBOAdapter;
import com.roselism.callpp.model.domain.filed.UserFiled;

/**
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 12:26
 * @packageName: com.roselism.callpp.model.domain.bmob
 */
public class BmobUser extends BmobIBOAdapter implements UserFiled {

    /**
     * 邮箱
     */
    private String email;

    /**
     * 用户的电话
     */
    private String phoneNumber;
    /**
     * 用户头像的url地址
     */
    private String profileUrl;
    /**
     * 用户邮箱是否验证
     */
    private boolean emailVerified;
    /**
     * 用户的昵称
     */
    private String nickName;
    /**
     * 密码
     */
    private String password;

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
