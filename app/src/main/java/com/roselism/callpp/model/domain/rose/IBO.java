package com.roselism.callpp.model.domain.rose;

/**
 * bussiness Objects
 * 业务类的属性接口
 * Created by simon on 2016/4/30.
 */
public interface IBO {

    /**
     * 获取id
     *
     * @return
     */
    String getObjectId();

    void setObjectId(String objectId);

    /**
     * 获取创建的时间
     *
     * @return
     */
    String getCreateDate();

    void setCreateDate(String createDate);

    /**
     * 获取最后更新时间
     *
     * @return
     */
    String getUpdateData();

    void setUpdateData(String updateData);

    /**
     * 获取不同的类型
     *
     * @return
     */
    String getType();

    /**
     * 设置当前bo类的类型
     *
     * @param type
     */
    void setType(String type);


}
