package com.roselism.callpp.model.abs;

import android.content.ContentValues;

import com.roselism.callpp.model.baas.Baas;
import com.roselism.callpp.model.baas.BmobUser;
import com.roselism.callpp.util.convert.Converter;

import java.util.List;

/**
 * 修正抽象角色
 * 抽象修正角色都以Rose为开头
 * 客户端调用
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 13:14
 * @packageName: com.roselism.callpp.model.domain
 */
public class RoseUser extends Rose implements IRoseUser {

    private Converter<RoseUser, ?> mConverter;
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

    public RoseUser(Baas baas) {
        super(baas);
    }

    /**
     * 设置转换器策略
     *
     * @param converter
     */
    public void setConverter(Converter<RoseUser, ?> converter) {
        this.mConverter = converter;
    }

    public <R> R convert() {
        return (R) mConverter.convert(this);
    }


    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
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

    /**
     * 登陆逻辑
     */
    public void login() {
        ContentValues contentValues = new ContentValues();
        mbaas.query(contentValues, new Baas.QueryListener<List<BmobUser>>() {
            @Override
            public void onQuery(List<BmobUser> bmobUsers) {
                if (bmobUsers != null && bmobUsers.size() > 0) {

                }
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    /**
     * 注册逻辑
     * 修正接口
     */
    public void signUp() {

    }
}
