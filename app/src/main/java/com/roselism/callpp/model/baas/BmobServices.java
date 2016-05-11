package com.roselism.callpp.model.baas;

import android.content.ContentValues;
import android.content.Context;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.model.abs.RoseUser;
import com.roselism.callpp.model.domain.adapter.ContentValues2BmobQuery;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

/**
 * Bmob 服务器的具体实现者
 * 对于bmob 服务器端 的增删改改查
 *
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/08 22:21
 * @packageName: com.roselism.callpp.model
 */
public class BmobServices implements Baas {
    private Context mcontext;

    public BmobServices() {
        mcontext = CallppApplication.getContext();
    }

    public BmobServices(Context context) {
        this.mcontext = context;
    }

    @Override
    public <R> void query(ContentValues values, final QueryListener<List<R>> listener) {
        BmobQuery<R> query = new ContentValues2BmobQuery().convert(values); // 将ContentValues 转换成查询语句
        query.findObjects(mcontext, new FindListener<R>() {
            @Override
            public void onSuccess(List<R> list) {
                listener.onQuery(list);
            }

//            RoseUser roseUser = new RoseUser() {


            @Override
            public void onError(int i, String s) {
                listener.onError(new Throwable(i + "" + s));
            }
        });
    }

    /**
     * 删除
     *
     * @param listener
     */
    @Override
    public void delete(DeleteListener listener) {
//        ContentValues
    }

    /**
     * 更新
     *
     * @param listener
     */
    @Override
    public void update(UpdateListener listener) {

    }

    /**
     * 插入
     *
     * @param listener
     */
    @Override
    public void insert(InsertListener listener) {

    }
}
