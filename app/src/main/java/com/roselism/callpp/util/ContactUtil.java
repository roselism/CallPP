package com.roselism.callpp.util;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.ContactsContract;

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
    /**
     * 获取所有本地联系人信息
     *
     * @return 所有的本地联系人信息
     */
    public static List<ContactInfo> getAllLocalContact(Context context) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// content://com.android.contacts/data.phones
        String[] projection = {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,//联系人姓名
                ContactsContract.CommonDataKinds.Phone.NUMBER,//联系人号码
                ContactsContract.CommonDataKinds.Phone.TIMES_CONTACTED,//联系次数
                ContactsContract.CommonDataKinds.Phone.LAST_TIME_CONTACTED,//最后通话时间
                ContactsContract.CommonDataKinds.Phone.HAS_PHONE_NUMBER,//是否有号码
                ContactsContract.CommonDataKinds.Phone._ID,//联系人ID
                ContactsContract.CommonDataKinds.Photo._ID,//联系人头像ID
                ContactsContract.CommonDataKinds.Phone.LOOKUP_KEY
        };
        Cursor cursor = resolver.query(uri, projection, null, null, null, null);
        List<ContactInfo> list = new ArrayList<>();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                //取出数据
                String name = cursor.getString(cursor.getColumnIndex(projection[0]));
                String number = cursor.getString(cursor.getColumnIndex(projection[1]));
                if (name == null)
                    name = number;
                int timesContacted = cursor.getInt(cursor.getColumnIndex(projection[2]));
                long lastTime = cursor.getLong(cursor.getColumnIndex(projection[3]));
                int hasPhoneNumber = cursor.getInt(cursor.getColumnIndex(projection[4]));
                long contactID = cursor.getLong(cursor.getColumnIndex(projection[5]));
                long photoID = cursor.getLong(cursor.getColumnIndex(projection[6]));
                String lookupKey = cursor.getString(cursor.getColumnIndex(projection[7]));
                Bitmap contactPhoto = null;
                //photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                if (photoID > 0) {
                    Uri photoUri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactID);
                    InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(resolver, photoUri);
                    contactPhoto = BitmapFactory.decodeStream(input);
                } else {
                    contactPhoto = BitmapFactory.decodeResource(UIUtils.getResources(), R.mipmap.ic_launcher);
                }
                //把联系人信息封装到集合中
                ContactInfo contactInfo = new ContactInfo(name, number, timesContacted, lastTime, hasPhoneNumber, contactID, photoID, contactPhoto,lookupKey);
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
        return null;
    }
}
