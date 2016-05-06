package com.roselism.callpp.model.engine.stragegy;

/**
 * 抽象测略类
 * 是所有增删改查的接口
 * Created by simon on 2016/4/30.
 *
 * @param <R> return type
 */
public interface Stragegy<R> {
    void run(OnOperatListener<R> listener);
}