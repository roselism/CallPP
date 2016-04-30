package com.roselism.callpp.model.domain.rose;

/**
 * Business Object
 * Created by simon on 2016/4/30.
 */
public abstract class RoseBO implements IBO, IBZ {

    /**
     * 对象的id
     */
    String objectId;

    /**
     * 上传日期
     */
    String createDate;

    /**
     * 最后更新日期
     */
    String updateData;

    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
