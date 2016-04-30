package com.roselism.callpp.model.engine.stragegy;


/**
 * Created by simon on 2016/4/30.
 *
 * @param <R> return type
 */
public interface OnOperatListener<R> {

    /**
     * 当成功时回掉
     *
     * @param t 需要返回的对象
     */
    void onSuccedd(R t);

    /**
     * 当失败时回掉
     *
     * @param error 产生的异常
     */
    void onError(Throwable error);
}