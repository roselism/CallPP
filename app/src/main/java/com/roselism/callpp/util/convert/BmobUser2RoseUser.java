package com.roselism.callpp.util.convert;

import com.roselism.callpp.model.domain.bmob.User;
import com.roselism.callpp.model.domain.rose.RoseObject;
import com.roselism.callpp.model.domain.rose.RoseUser;

/**
 * bmobuser和roseuser 对象之间的转换器
 * Created by simon on 2016/4/30.
 */
public class BmobUser2RoseUser implements Converter<User, RoseUser> {
    @Override
    public RoseUser convert(User parameter) {
        RoseUser user = new RoseUser();
        user.setCreateDate(parameter.getCreatedAt());
        user.setObjectId(parameter.getObjectId());
        user.setUpdateData(parameter.getUpdatedAt());
        user.setType(RoseObject.BMOB_TYPE); // 设置类型
        user.setEmail(parameter.getEmail());

        return new RoseUser();
    }
}