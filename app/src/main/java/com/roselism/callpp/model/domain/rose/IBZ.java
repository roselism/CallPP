package com.roselism.callpp.model.domain.rose;

/**
 * 业务类的业务接口
 * Created by simon on 2016/4/30.
 */
public interface IBZ {

    /**
     * 添加方法
     */
    <R> void save(OnSaveListener<R> listener);

    /**
     * 更新
     */
    void update();

    /**
     * 删除
     */
    void delete();
}
