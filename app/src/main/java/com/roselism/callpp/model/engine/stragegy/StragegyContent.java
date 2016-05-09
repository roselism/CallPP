package com.roselism.callpp.model.engine.stragegy;


/**
 * Created by simon on 2016/4/30.
 * 测略和监听器的泛性
 * 就是监听器的返回参数类型
 * <p/>
 * 这个上下文对象不应该以这样的方式出现在这里，上下文对象应该就是需要使用策略的类
 *
 * @param <T>
 * @deprecated 不再使用，请使用最新的环境角色
 */
public class StragegyContent<T> {
    Stragegy<T> stragegy;

    /**
     * 创建一个测略包裹对象
     *
     * @param stragegy 要被执行测略
     */
    public void setStragegy(Stragegy<T> stragegy) {
        this.stragegy = stragegy;
    }

    /**
     * 执行测略
     *
     * @param listener 操作监听器
     */
    public void run(OnOperatListener<T> listener) {
        if (stragegy == null)
            throw new NullPointerException("策略不能为null");
        stragegy.run(listener);
    }
}
