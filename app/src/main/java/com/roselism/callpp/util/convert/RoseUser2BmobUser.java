package com.roselism.callpp.util.convert;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseUser;

/**
 * Created by simon on 2016/4/30.
 */
public class RoseUser2BmobUser implements Converter<RoseUser, User> {
    @Override
    public User convert(RoseUser parameter) {
        User user = new User();
        user.setEmail(parameter.getEmail());
        user.setUsername(parameter.getEmail());
        user.setPassword(parameter.getPassword());

        return user;
    }
}
