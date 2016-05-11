package com.roselism.callpp.model.abs;

import com.roselism.callpp.model.baas.Baas;

/**
 * 业务抽象角色
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/09 23:35
 * @packageName: com.roselism.callpp.model.domain.hyper
 */
public abstract class Rose implements IRose {

    /**
     * 持有一个具体实现角色对象（聚合）
     */
    protected Baas mbaas;

    private String objectId;
    private String createDate;
    private String updateData;
    private String type;

    public Rose(Baas baas) {
        this.mbaas = baas;
    }

    @Override
    public String getObjectId() {
        return objectId;
    }

    @Override
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    @Override
    public String getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getUpdateData() {
        return updateData;
    }

    @Override
    public void setUpdateData(String updateData) {
        this.updateData = updateData;
    }

    @Override
    public String getType() {
        return type;
    }
}
