package com.roselism.callpp.model.domain.hyper;

import com.roselism.callpp.model.domain.Baas;

/**
 * 业务抽象角色
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/09 23:35
 * @packageName: com.roselism.callpp.model.domain.hyper
 */
public abstract class Rose implements IBO {
    protected Baas mbaas;

    public Rose(Baas baas) {
        this.mbaas = baas;
    }
}
