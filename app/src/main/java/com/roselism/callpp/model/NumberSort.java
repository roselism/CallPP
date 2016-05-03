package com.roselism.callpp.model;

import com.roselism.callpp.model.bean.ContactInfo;

import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/3 23:39
 * @描述 根据电话号码进行排序
 */
public class NumberSort implements ContactSortStrategy {
    @Override
    public void sort(List<ContactInfo> contactInfos) {
        quicksort(contactInfos, 0, contactInfos.size() - 1);
    }


    /**
     * 快速排序
     *
     * @param infos
     */
    public static void quicksort(List<ContactInfo> infos, int left, int right) {
        if (right - left <= 0) {
            return;
        }
        // 右边
        int parttion = parttion(infos, left, right, infos.get(right));
        // 排序左边
        quicksort(infos, left, parttion - 1);
        // 排序右边
        quicksort(infos, parttion + 1, right);
    }

    /**
     * 划分数组
     *
     * @param infos
     * @param left
     *            最左边
     * @param right
     *            最右边
     * @param contactInfo
     *            关键字
     */
    public static int parttion(List<ContactInfo> infos, int left, int right, ContactInfo contactInfo) {
        int leftPtr = left - 1;// 左指针
        int rightPtr = right;// 右指针
        while (true) {
            // 循环,将比关键字大的留在左端
            while (leftPtr < rightPtr && infos.get(++leftPtr).getNumber().compareTo(contactInfo.getNumber())<0)
                ;
            // 循环,将比关键字小的留在右端
            while (rightPtr > leftPtr && infos.get(--rightPtr).getNumber().compareTo(contactInfo.getNumber())>0)
                ;
            if (rightPtr <= leftPtr) {
                break;
            } else {
                ContactInfo tmp = infos.get(leftPtr);
                infos.set(leftPtr, infos.get(rightPtr));
                infos.set(rightPtr,tmp);
            }
        }
        ContactInfo tmp = infos.get(leftPtr);
        infos.set(leftPtr,infos.get(right));
        infos.set(right, tmp);
        return leftPtr;
    }
}
