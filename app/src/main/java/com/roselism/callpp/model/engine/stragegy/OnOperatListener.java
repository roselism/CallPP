package com.roselism.callpp.model.engine.stragegy;


/**
 * Created by simon on 2016/4/30.
 *
 * @param <R> return type
 * @deprecated 不再推荐使用，请使用特定的回掉接口替代
 */
public interface OnOperatListener<R> {

    /**
     * 当操作成功时回调
     *
     * @param t 需要返回的对象
     */
    void onSuccedd(R t);

    /**
     * 当操作失败时回调
     * 操作不成功
     *
     * @param error 产生的异常
     */
    void onError(Throwable error);
}