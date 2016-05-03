package com.roselism.callpp.model;

import com.roselism.callpp.model.bean.ContactInfo;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/3 23:17
 * @描述 联系人排序策略
 */
public interface ContactSortStrategy {
    /**
     * 排序方法
     * @param contactInfos 要排序的联系人
     */
    void sort(List<ContactInfo> contactInfos);
}
