package com.roselism.callpp.model.engine.stragegy;

import com.roselism.callpp.model.baas.Baas;
import com.roselism.callpp.model.baas.BmobUser;

import cn.bmob.v3.BmobQuery;

/**
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/09 22:29
 * @packageName: com.roselism.callpp.model.engine.stragegy.query
 */
public class QueryBmobUserStragegy extends QueryUserStragegy {
    @Override
    public void query(Baas.QueryListener listener) {
        BmobQuery<BmobUser> query = new BmobQuery<>();
        query.addWhereEqualTo("wanghzne", "adsf");
//        query.findObjects();
    }
}
