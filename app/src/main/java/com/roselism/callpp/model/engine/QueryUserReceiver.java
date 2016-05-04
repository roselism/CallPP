package com.roselism.callpp.model.engine;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseUser;
import com.roselism.callpp.model.engine.stragegy.OnOperatListener;
import com.roselism.callpp.model.engine.stragegy.query.bmob.QueryUserByEmailStragegy;
import com.roselism.callpp.model.engine.stragegy.StragegyContent;
import com.roselism.callpp.util.convert.BmobUser2RoseUser;
import com.roselism.callpp.util.convert.Converter;


/**
 * 查询user的接收器
 * 里面封装的都是查询User的方法
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
        StragegyContent<User> content = new StragegyContent();
        content.setStragegy(new QueryUserByEmailStragegy(email));
        content.run(new OnOperatListener<User>() {
            @Override
            public void onSuccedd(User bmobUser) { // bmobuser查询

                if (bmobUser != null) { // 查有此人
                    // 将查询到的bmobuser转换成为roseuser对象
                    Converter<User, RoseUser> converter = new BmobUser2RoseUser();
                    RoseUser roseUser = converter.convert(bmobUser);
                    listener.onSuccedd(roseUser);
                } else {
                    listener.onSuccedd(null); // 查询成功但是没有这个人
                }
            }

            @Override
            public void onError(Throwable error) {
                listener.onError(error);
            }
        });


    }
}