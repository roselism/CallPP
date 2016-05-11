package com.roselism.callpp.model.domain.adapter;

import com.roselism.callpp.model.domain.dust.BmobBaseUser;
import com.roselism.callpp.model.domain.dust.RoseObject;
import com.roselism.callpp.model.domain.dust.RoseUser;
import com.roselism.callpp.util.convert.Converter;

/**
 * bmobuser和roseuser 对象之间的转换器
 * Created by simon on 2016/4/30.
 */
public class BmobUser2RoseUser implements Converter<BmobBaseUser, RoseUser> {
    @Override
    public RoseUser convert(BmobBaseUser bmobBmobBaseUser) {
        RoseUser roseUser = new RoseUser();
        roseUser.setCreateDate(bmobBmobBaseUser.getCreatedAt());
        roseUser.setObjectId(bmobBmobBaseUser.getObjectId());
        roseUser.setUpdateData(bmobBmobBaseUser.getUpdatedAt());
        roseUser.setType(RoseObject.BMOB_TYPE); // 设置类型
        roseUser.setEmail(bmobBmobBaseUser.getEmail());
        roseUser.setPhoneNumber(bmobBmobBaseUser.getMobilePhoneNumber());

        return new RoseUser();
    }
}