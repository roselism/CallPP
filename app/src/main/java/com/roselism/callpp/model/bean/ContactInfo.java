package com.roselism.callpp.model.bean;

import android.graphics.Bitmap;

/**
 * @创建者 lai
 * @创建时间 2016/5/1
 * @packageName com.roselism.callpp.model.local
 * @更新时间 2016/5/1 17:05
 * @描述 电话联系信息
 */
public class ContactInfo {
    private String displayName;//联系人姓名
    private String number;//联系人号码
    private int    timesContacted;//联系次数
    private long   lastTimeContacted;//最后通话时间
    private int hasPhoneNumber;//是否有号码
    private long contactID;//联系人ID
    private long photoID;//联系人头像ID
    private Bitmap photo;//图片

    public ContactInfo(String displayName, String number, int timesContacted, long lastTimeContacted, int hasPhoneNumber, long contactID, long photoID, Bitmap photo) {
        this.displayName = displayName;
        this.number = number;
        this.timesContacted = timesContacted;
        this.lastTimeContacted = lastTimeContacted;
        this.hasPhoneNumber = hasPhoneNumber;
        this.contactID = contactID;
        this.photoID = photoID;
        this.photo = photo;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getTimesContacted() {
        return timesContacted;
    }

    public void setTimesContacted(int timesContacted) {
        this.timesContacted = timesContacted;
    }

    public long getLastTimeContacted() {
        return lastTimeContacted;
    }

    public void setLastTimeContacted(long lastTimeContacted) {
        this.lastTimeContacted = lastTimeContacted;
    }

    public int getHasPhoneNumber() {
        return hasPhoneNumber;
    }

    public void setHasPhoneNumber(int hasPhoneNumber) {
        this.hasPhoneNumber = hasPhoneNumber;
    }

    public long getContactID() {
        return contactID;
    }

    public void setContactID(long contactID) {
        this.contactID = contactID;
    }

    public long getPhotoID() {
        return photoID;
    }

    public void setPhotoID(long photoID) {
        this.photoID = photoID;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
