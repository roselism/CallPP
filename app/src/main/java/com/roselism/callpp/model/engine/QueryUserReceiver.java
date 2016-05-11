package com.roselism.callpp.model.engine;

import com.roselism.callpp.model.domain.adapter.BmobUser2RoseUser;
import com.roselism.callpp.model.domain.adapter.RoseUser2BmobUser;
import com.roselism.callpp.model.domain.dust.BmobBaseUser;
import com.roselism.callpp.model.domain.dust.RoseUser;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.StragegyContent;
import com.roselism.callpp.model.engine.stragegy.query.QueryUserBmobByEmailStragegy;
import com.roselism.callpp.model.engine.stragegy.query.UserBmobLoginStragegy;
import com.roselism.callpp.util.convert.Converter;

/**
 * 查询user的接收器
 * 里面封装的都是查询User的方法
 * 是整个框架中唯一需要修改的类
 * Created by simon on 2016/4/30.
 */
public class QueryUserReceiver {

    OnOperatListener<RoseUser> listener;

    /**
     * @param listener 监听器
     */
    public QueryUserReceiver(OnOperatListener<RoseUser> listener) {
        this.listener = listener;
    }

    /**
     * 通过邮箱查询User
     */
    void queryUserByEmail(String email) {

        // 获取Bmob的user对象
        StragegyContent<BmobBaseUser> content = new StragegyContent();
        content.setStragegy(new QueryUserBmobByEmailStragegy(email));
        content.run(new OnOperatListener<BmobBaseUser>() {

            /**
             * 查询成功
             * 如果有该对象，则返回该user对象
             * 如果没有该对象，则返回null
             * @param bmobBmobBaseUser 查询到的bmobuser对象
             */
            @Override
            public void onSuccedd(BmobBaseUser bmobBmobBaseUser) { // bmobuser查询

                if (bmobBmobBaseUser != null) { // 查有此人
                    // 将查询到的bmobuser转换成为roseuser对象
                    Converter<BmobBaseUser, RoseUser> converter = new BmobUser2RoseUser();
                    RoseUser roseUser = converter.convert(bmobBmobBaseUser);
                    listener.onSuccedd(roseUser);
                } else {
                    listener.onSuccedd(null); // 查询成功但是没有这个人
                }
            }

            /**
             * 查询时候的异常
             * @param error 产生的异常
             */
            @Override
            public void onError(Throwable error) {
                listener.onError(error);
            }
        });
    }

    /**
     * 用户登录逻辑
     *
     * @param roseUser 要登录的用户
     */
    void login(RoseUser roseUser) {
        RoseUser2BmobUser converter = new RoseUser2BmobUser();
        BmobBaseUser bmobBaseUser = converter.convert(roseUser); // 转换成bmobuser
        StragegyContent<BmobBaseUser> content = new StragegyContent();
        content.setStragegy(new UserBmobLoginStragegy(bmobBaseUser));
        content.run(new OnOperatListener<BmobBaseUser>() {
            @Override
            public void onSuccedd(BmobBaseUser t) {
                listener.onSuccedd(new BmobUser2RoseUser().convert(t));
            }

            @Override
            public void onError(Throwable error) {
                listener.onError(error);
            }
        });
    }

    /**
     * 查询用户是否存在
     * 比如：
     * 提供email 和 password 来查寻这个用户是否为合法用户
     * 提供email 来查寻这个用户是否存在
     * 提供手机号码来查询这个手机是否已经存在，如果存在
     * 如果存在则返回这个user，如果不存在则返回null
     *
     * @param user 要被查询的用户
     * @deprecated 还未完成，请勿使用
     */
    void queryUserByInfo(RoseUser user) {
        RoseUser2BmobUser roseUser2BmobUser = new RoseUser2BmobUser();
        BmobBaseUser bmobBmobBaseUser = roseUser2BmobUser.convert(user);
    }
}
