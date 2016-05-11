package com.roselism.callpp.model.abs;

/**
 * 抽象角色
 * bussiness Objects
 * 业务类的属性接口
 * <p>
 * Created by simon on 2016/4/30.
 * 提供了业务类的基本接口
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

}