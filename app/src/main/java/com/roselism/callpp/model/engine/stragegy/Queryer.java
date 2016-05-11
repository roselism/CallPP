package com.roselism.callpp.model.engine.stragegy;

import com.roselism.callpp.model.baas.Baas;

/**
 * 抽象查询器，所有具体查询策略的父类
 * 上下文对象
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/07 22:21
 * @packageName: com.roselism.callpp.model.engine
 */
public class Queryer<R> {
    QueryStragegy<R> stragegy;

    /**
     * 创建一个测略包裹对象
     *
     * @param stragegy 要被执行测略
     */
    public void setStragegy(QueryStragegy<R> stragegy) {
        this.stragegy = stragegy;
    }

    /**
     * 执行测略
     *
     * @param listener 操作监听器,顶级回调对象
     */
    public void query(Baas.QueryListener<R> listener) {
        if (stragegy == null)
            throw new NullPointerException("策略不能为null");
//        stragegy.run(listener);
        stragegy.query(listener);
    }
}
