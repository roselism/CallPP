package com.roselism.callpp.util;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.roselism.callpp.CallppApplication;

/**
 * 用于读取本机的电话号码
 * Created by simon on 16-5-3.
 */
public class PhoneUtil {

    /**
     * 尝试获取手机号码
     * 注意：这是一种很老的方式，现在一般用不成
     *
     * @return 本机手机号码
     */
    public static String readPhoneNumber() {
        TelephonyManager telephonyManager = (TelephonyManager) CallppApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
        return telephonyManager.getLine1Number();
    }
}
