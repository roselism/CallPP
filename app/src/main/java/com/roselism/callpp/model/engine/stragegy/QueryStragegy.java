package com.roselism.callpp.model.engine.stragegy;

import com.roselism.callpp.model.domain.Baas;

/**
 * 抽象查询策略
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/07 21:59
 * @packageName: com.roselism.callpp.model.engine.stragegy
 */
public interface QueryStragegy<R> {

    void query(Baas.QueryListener listener);
}
