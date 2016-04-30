package com.roselism.callpp.model.domain.rose;

import com.roselism.callpp.model.domain.bmob.User;

/**
 * Created by simon on 2016/4/30.
 */
public class RoseUser extends RoseBO {
    String email;

    /**
     * 适配
     *
     * @param user 需要适配的user
     */
    public RoseUser(User user) {
        this.email = user.getEmail();
        this.createDate = user.getCreatedAt();
        this.objectId = user.getObjectId();
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}