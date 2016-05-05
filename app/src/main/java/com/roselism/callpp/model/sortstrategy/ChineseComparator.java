package com.roselism.callpp.model.sortstrategy;

import android.support.annotation.NonNull;

import com.roselism.callpp.model.bean.ContactInfo;

import java.util.Comparator;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/3 23:23
 * @描述 按照拼音比较进行排序
 */
public class ChineseComparator implements Comparator<ContactInfo> {

    @Override
    public int compare(@NonNull ContactInfo lhs,@NonNull ContactInfo rhs) {
        return lhs.getDisplayName().compareTo(rhs.getDisplayName());
    }
}
