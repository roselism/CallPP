package com.roselism.callpp.util;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.roselism.callpp.R;
import com.roselism.callpp.model.bean.ContactInfo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @创建者 lai
 * @创建时间 2016/5/1
 * @packageName com.roselism.callpp.util
 * @更新时间 2016/5/1 17:04
 * @描述 获取联系人信息的工具类
 */
public class ContactUtil {
    private static final String[] CONTACT_PROJECTION = {
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,// 联系人姓名0
            ContactsContract.CommonDataKinds.Phone.NUMBER,// 联系人号码1
            ContactsContract.CommonDataKinds.Phone.TIMES_CONTACTED,// 联系次数2
            ContactsContract.CommonDataKinds.Phone.LAST_TIME_CONTACTED,// 最后通话时间3
            ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER,// 是否有号码4
            ContactsContract.CommonDataKinds.Phone.CONTACT_ID,// 联系人ID 5
            ContactsContract.CommonDataKinds.Photo.PHOTO_ID,// 联系人头像ID 6
            ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY// 7
    };

    /**
     * 获取所有本地联系人信息
     *
     * @return 所有的本地联系人信息
     */
    public static List<ContactInfo> getAllLocalContact(Context context) {
        List<ContactInfo> list = getPhoneContacts(context);
        list.addAll(getSIMContacts(context));
        return list;
    }

    /**
     * 获取手机联系人的信息
     *
     * @param context context
     *
     * @return 所有的手机联系人的信息
     */
    private static List<ContactInfo> getPhoneContacts(Context context) {
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// content://com.android.contacts/data.phones
        return getContacts(context, uri);
    }

    /**
     * 得到SIM卡联系人信息
     */
    private static List<ContactInfo> getSIMContacts(Context context) {
        // 获取Sims卡联系人
        Uri uri = Uri.parse("content://icc/adn");
        return getContacts(context, uri);
    }

    @NonNull
    private static List<ContactInfo> getContacts(Context context, Uri uri) {
        ContentResolver resolver = context.getContentResolver();
        Cursor cursor = resolver.query(uri, CONTACT_PROJECTION, null, null, "display_name asc", null);
        List<ContactInfo> list = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                // 取出数据
                String name = cursor.getString(cursor.getColumnIndex(CONTACT_PROJECTION[0]));
                String number = cursor.getString(cursor
                        .getColumnIndex(CONTACT_PROJECTION[1]));
                if (name == null)
                    name = number;
                int timesContacted = cursor.getInt(cursor.getColumnIndex(CONTACT_PROJECTION[2]));
                long lastTime = cursor.getLong(cursor.getColumnIndex(CONTACT_PROJECTION[3]));
                int hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(CONTACT_PROJECTION[4]));
                long contactID = cursor.getLong(cursor.getColumnIndex(CONTACT_PROJECTION[5]));
                long photoID = cursor.getLong(cursor.getColumnIndex(CONTACT_PROJECTION[6]));
                String lookupKey = cursor.getString(cursor.getColumnIndex(CONTACT_PROJECTION[7]));
                // //得到联系人头像Bitamp
                Bitmap contactPhoto = null;
                // photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (photoID > 0) {
                    Uri phontoUri = ContentUris.withAppendedId(                            ContactsContract.Contacts.CONTENT_URI, contactID);
                    InputStream input = ContactsContract.Contacts                            .openContactPhotoInputStream(resolver, phontoUri);
                    contactPhoto = BitmapFactory.decodeStream(input);
                } else {
                    contactPhoto = BitmapFactory.decodeResource(                            UIUtils.getResources(), R.mipmap.ic_contact);
                }
                // 把联系人信息封装到集合中
                ContactInfo contactInfo = new ContactInfo(name, number,
                        timesContacted, lastTime, hasPhoneNumber, contactID,
                        contactPhoto, lookupKey);
                list.add(contactInfo);
            }
            cursor.close();
        }
        return list;
    }

    /**
     * 从网络获取联系人信息
     *
     * @return 所有网络中的联系人信息
     */
    public static List<ContactInfo> getAllNetContact() {
        return new ArrayList<>();
    }

    public static void callPhone(String number) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                + number));
        if (ActivityCompat.checkSelfPermission(UIUtils.getContext(),
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            // ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            // public void onRequestPermissionsResult(int requestCode, String[]
            // permissions,
            // int[] grantResults)
            // to handle the case where the user grants the permission. See the
            // documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        UIUtils.getContext().startActivity(intent);
    }

}
