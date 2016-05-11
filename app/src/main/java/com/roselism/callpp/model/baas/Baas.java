package com.roselism.callpp.model.baas;

import android.content.ContentValues;

import java.util.List;

/**
 * 抽象具体实现接口
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 22:23
 * @packageName: com.roselism.callpp.model
 */
public interface Baas {

    <R> void query(ContentValues values, QueryListener<List<R>> listener);

    void delete(DeleteListener listener);

    void update(UpdateListener listener);

    void insert(InsertListener listener);

    /**
     * @author: Hyper Simon Wang
     * @create_time: 2016/05/09 21:31
     * @packageName: com.roselism.callpp.model.engine.stragegy.query
     */
    interface DeleteListener {
        void onDelete();
    }

    /**
     * 插入监听接口
     * 不需要有返回值
     *
     * @author: Hyper Simon Wang
     * @create_time: 2016/05/07 22:09
     * @packageName: com.roselism.callpp.model.engine.stragegy
     */
    interface InsertListener {
        void onInsert();
    }

    /**
     * 针对查询的监听器，一种泛型顶级接口
     *
     * @param <R> return type
     * @SAM
     * @author: Hyper Simon Wang
     * @create_time: 2016/05/07 22:03
     * @packageName: com.roselism.callpp.model.engine.stragegy
     */
    interface QueryListener<R> {
        void onQuery(R r);
    }

    /**
     *
     */
    interface UpdateListener {
        void onUpdate();
    }

}
