package com.roselism.callpp.model.engine.stragegy;

/**
 * 针对查询的监听器，一种泛型顶级接口
 *
 * @param <R> return type
 * @SAM
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/07 22:03
 * @packageName: com.roselism.callpp.model.engine.stragegy
 */
public interface OnQueryListener<R> {
    void queryFinish(R r);
}
