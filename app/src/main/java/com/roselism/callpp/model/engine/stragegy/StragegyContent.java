package com.roselism.callpp.model.engine.stragegy;

/**
 * Created by simon on 2016/4/30.
 */
public class StragegyContent<T> {
    Stragegy<T> stragegy;

    public void setStragegy(Stragegy<T> stragegy) {
        this.stragegy = stragegy;
    }

    public void run(OnOperatListener<T> listener) {
        if (stragegy == null)
            throw new NullPointerException("策略不能为null");
        stragegy.run(listener);
    }
}
