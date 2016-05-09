package com.roselism.callpp.model.adapter;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseUser;
import com.roselism.callpp.util.convert.Converter;

/**
 * RoseUser 和 bmobUser 之间的适配器
 * <p>
 * Created by simon on 2016/4/30.
 */
public class RoseUser2BmobUser implements Converter<RoseUser, User> {
    @Override
    public User convert(RoseUser roseUser) {
        User bmobUser = new User(); // bmob bmobUser
        bmobUser.setEmail(roseUser.getEmail());
        bmobUser.setUsername(roseUser.getEmail()); // mUser name 也设置为email
        bmobUser.setPassword(roseUser.getPassword());
        bmobUser.setObjectId(roseUser.getObjectId());
        bmobUser.setEmailVerified(roseUser.isEmailVerified());
        bmobUser.setMobilePhoneNumber(roseUser.getPhoneNumber());

        return bmobUser;
    }
}
