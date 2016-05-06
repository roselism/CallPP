package com.roselism.callpp.model.adapter;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseObject;
import com.roselism.callpp.model.domain.rose.RoseUser;
import com.roselism.callpp.util.convert.Converter;

/**
 * bmobuser和roseuser 对象之间的转换器
 * Created by simon on 2016/4/30.
 */
public class BmobUser2RoseUser implements Converter<User, RoseUser> {
    @Override
    public RoseUser convert(User bmobUser) {
        RoseUser roseUser = new RoseUser();
        roseUser.setCreateDate(bmobUser.getCreatedAt());
        roseUser.setObjectId(bmobUser.getObjectId());
        roseUser.setUpdateData(bmobUser.getUpdatedAt());
        roseUser.setType(RoseObject.BMOB_TYPE); // 设置类型
        roseUser.setEmail(bmobUser.getEmail());
        roseUser.setPhoneNumber(bmobUser.getMobilePhoneNumber());

        return new RoseUser();
    }
}