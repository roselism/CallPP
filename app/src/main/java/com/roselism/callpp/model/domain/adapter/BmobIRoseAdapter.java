package com.roselism.callpp.model.domain.adapter;

import com.roselism.callpp.model.abs.IRose;

import cn.bmob.v3.BmobObject;

/**
 * 为BmobObject和IBO之间的适配
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 13:40
 * @packageName: com.roselism.callpp.model.domain
 */
public class BmobIRoseAdapter extends BmobObject implements IRose {
    public final String type = "BMOB";

    @Override
    public String getCreateDate() {
        return this.getCreatedAt();
    }

    @Override
    public void setCreateDate(String createDate) {
        this.setCreatedAt(createDate);
    }

    @Override
    public String getUpdateData() {
        return this.getUpdatedAt();
    }

    @Override
    public void setUpdateData(String updateData) {
        this.setUpdatedAt(updateData);
    }

    @Override
    public String getType() {
        return type;
    }

}
