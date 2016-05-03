package com.roselism.callpp;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.roselism.callpp.model.bean.ContactInfo;
import com.roselism.callpp.util.ContactUtil;

import java.util.List;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing
 * Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    // 测试本地联系人是否获取成功
    public void testQueryContact() {
        List<ContactInfo> contactInfos = ContactUtil.getAllLocalContact(getContext());
        for (int i = 0; i < contactInfos.size(); i++) {
            ContactInfo info = contactInfos.get(i);
            Log.d("ApplicationTest", info.getDisplayName());
            Log.d("ApplicationTest", info.getNumber());
            Log.d("ApplicationTest", "info.getTimesContacted():" + info.getTimesContacted());
            Log.d("ApplicationTest", "info.   getLastTimeContacted():" + info.getLastTimeContacted());
            Log.d("ApplicationTest", "info.getHasPhoneNumber():" + info.getHasPhoneNumber());
            Log.d("ApplicationTest", "info.   getContactID():" + info.getContactID());
//            Log.d("ApplicationTest", "info.getPhotoID():" + info.getPhotoID());
            Log.d("ApplicationTest", "info.   getPhoto():" + info.getPhoto());
            Log.d("ApplicationTest", info.getLookupKey());
        }
    }
}