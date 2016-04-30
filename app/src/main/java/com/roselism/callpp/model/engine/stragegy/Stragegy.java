package com.roselism.callpp.model.engine.stragegy;

/**
 * Created by simon on 2016/4/30.
 *
 * @param <R> return type
 */
public interface Stragegy<R> {
    void run(OnOperatListener<R> listener);
}