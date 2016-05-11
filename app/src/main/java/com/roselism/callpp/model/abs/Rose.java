package com.roselism.callpp.model.abs;

import com.roselism.callpp.model.baas.Baas;

/**
 * 业务抽象角色
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/09 23:35
 * @packageName: com.roselism.callpp.model.domain.hyper
 */
public abstract class Rose implements IBO {

    /**
     * 持有一个具体实现角色对象（聚合）
     */
    protected Baas mbaas;

    public Rose(Baas baas) {
        this.mbaas = baas;
    }

}
