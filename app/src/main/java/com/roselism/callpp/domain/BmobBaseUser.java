package com.roselism.callpp.domain;

/**
 * Created by simon on 2016/4/30.
 */
public class BmobBaseUser extends cn.bmob.v3.BmobUser {

    // 图片的url地址
    String profileUrl;

    // 用户的昵称
    String nickName;

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

