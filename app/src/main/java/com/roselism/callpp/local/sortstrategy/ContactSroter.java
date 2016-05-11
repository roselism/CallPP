package com.roselism.callpp.local.sortstrategy;

import com.roselism.callpp.local.bean.ContactInfo;

import java.util.Collections;
import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/3 23:28
 * @描述 提供联系人排序的算法
 */
public class ContactSroter {
    public static final int NUMBER_MODE  = 0;//根据电话号码进行排序
    public static final int CHINESE_MODE = 1;

    /**
     * @param contactInfos 要排序的联系人集合
     * @param mode         使用哪种策略进行排序
     *                     NUMBER_MODE: 根据电话号码进行排序
     *                     CHINESE_MODE:根据拼音进行排序
     *
     * @return 根据排序策略排序好的集合
     */
    public void sortContacts(List<ContactInfo> contactInfos, int mode) {
        switch (mode) {
            case CHINESE_MODE:
                ContactInfo.setComparator(new ChineseComparator());
                break;
            case NUMBER_MODE:
            default:
                ContactInfo.setComparator(new NumberComparator());
        }
        Collections.sort(contactInfos);
    }
}
