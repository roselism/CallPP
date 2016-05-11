package com.roselism.callpp.model;

import com.roselism.callpp.model.abs.Rose;
import com.roselism.callpp.model.baas.Baas;
import com.roselism.callpp.util.convert.Converter;

import cn.bmob.v3.datatype.BmobTableSchema;

/**
 * 修正抽象角色
 * 抽象修正角色都以Rose为开头
 * 客户端调用
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 13:14
 * @packageName: com.roselism.callpp.model.domain
 */
public class RoseUser extends Rose {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String getObjectId() {
        return null;
    }

    @Override
    public void setObjectId(String objectId) {

    }

    @Override
    public String getCreateDate() {
        return null;
    }

    @Override
    public void setCreateDate(String createDate) {

    }

    @Override
    public String getUpdateData() {
        return null;
    }

    @Override
    public void setUpdateData(String updateData) {

    }

    @Override
    public String getType() {
        return null;
    }

    /**
     * 设置转换器策略
     *
     * @param converter
     */
    public void setConverter(Converter<RoseUser, ?> converter) {
        this.mConverter = converter;
    }

    /**
     * 登陆逻辑
     */
    public void login() {
//        BmobTableSchema
    }

    /**
     * 注册逻辑
     * 修正接口
     */
    public void signUp() {

    }
}
