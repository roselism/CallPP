package com.roselism.callpp.model.domain.adapter;

import com.roselism.callpp.model.domain.dust.BmobBaseUser;
import com.roselism.callpp.model.domain.dust.RoseUser;
import com.roselism.callpp.util.convert.Converter;

/**
 * RoseUser 和 bmobUser 之间的适配器
 * <p>
 * Created by simon on 2016/4/30.
 */
public class RoseUser2BmobUser implements Converter<RoseUser, BmobBaseUser> {
    @Override
    public BmobBaseUser convert(RoseUser roseUser) {
        BmobBaseUser bmobBmobBaseUser = new BmobBaseUser(); // bmob bmobBmobBaseUser
        bmobBmobBaseUser.setEmail(roseUser.getEmail());
        bmobBmobBaseUser.setUsername(roseUser.getEmail()); // mUser name 也设置为email
        bmobBmobBaseUser.setPassword(roseUser.getPassword());
        bmobBmobBaseUser.setObjectId(roseUser.getObjectId());
        bmobBmobBaseUser.setEmailVerified(roseUser.isEmailVerified());
        bmobBmobBaseUser.setMobilePhoneNumber(roseUser.getPhoneNumber());

        return bmobBmobBaseUser;
    }
}
