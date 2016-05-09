package com.roselism.callpp.model.engine.stragegy;

/**
 * 抽象测略类
 * 是所有增删改查的接口
 * Created by simon on 2016/4/30.
 *
 * @param <R> return type
 * @deprecated 不再推荐使用，请使用特定的抽象类替代
 */
public interface Stragegy<R> {
    void run(OnOperatListener<R> listener);
}