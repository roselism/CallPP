package com.roselism.callpp.util;

import android.content.Context;
import android.content.res.Resources;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.R;
import com.roselism.callpp.util.convert.InStream2String;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;

/**
 * 配置文件的工具类
 * 用于读取配置文件
 * Created by simon on 16-5-3.
 */
public class ConfigUtil {

    static Context mContext;

    // 给mContext 赋值
    static {
        mContext = CallppApplication.getContext();
    }

    /**
     * @param name
     * @return
     */
    public static String getAppKey(String name) throws XmlPullParserException, IOException {
        String appKey = "";

        Resources resources = mContext.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.config);
        InStream2String converter = new InStream2String(); // 输入流转String
        String xml = converter.convert(inputStream);

        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        Reader reader = new StringReader(xml);
        parser.setInput(reader);
        int type = parser.getEventType();
        while (type != XmlPullParser.END_DOCUMENT) {
            if (type == XmlPullParser.START_TAG) { // 开始标签
                if ("appkey".equals(parser.getName())) {
                    appKey = parser.nextText();
                }
            }
        }
        return appKey;
    }
}
