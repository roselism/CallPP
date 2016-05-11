package com.roselism.callpp.model.domain.adapter;

import android.content.ContentValues;
import android.text.TextUtils;

import com.roselism.callpp.model.baas.BmobUser;
import com.roselism.callpp.util.convert.Converter;

import cn.bmob.v3.BmobQuery;

/**
 * @author: Hyper Simon Wang
 * @create_time: 2016/05/11 10:11
 * @packageName: com.roselism.callpp.util.convert
 */
public class ContentValues2BmobQuery implements Converter<ContentValues, BmobQuery> {

    @Override
    public BmobQuery convert(ContentValues values) {
//        BmobUser bmobUser = new BmobUser();

        BmobQuery<BmobUser> query = new BmobQuery<>();

        assignIfNonNull(query, values, BmobUser.EMAIL);
        assignIfNonNull(query, values, BmobUser.EMAILVERIFIED);
        assignIfNonNull(query, values, BmobUser.NICKNAME);
        assignIfNonNull(query, values, BmobUser.PHONE_NUMBER);
        assignIfNonNull(query, values, BmobUser.PROFILE_URL);
        assignIfNonNull(query, values, BmobUser.PASSWORD);

        return query;
    }

    /**
     *
     *
     * @param filedName
     */

    /**
     * 不为null即赋值
     *
     * @param query     查询语句
     * @param values    值
     * @param filedName 字段
     */
    private void assignIfNonNull(BmobQuery query, ContentValues values, String filedName) {
        if (!TextUtils.isEmpty(values.getAsString(filedName)))
            query.addWhereEqualTo(filedName, values.getAsString(filedName));
    }
}
