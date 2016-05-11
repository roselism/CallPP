package com.roselism.callpp.util;

import android.content.Context;
import android.content.res.Resources;

import com.roselism.callpp.CallppApplication;
import com.roselism.callpp.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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
     * 根据配置的名称返回配置的appKey
     *
     * @param name 配置名 不区分大小写
     * @return 配置的appkey信息，无相应的配置名称则返回空字符串
     * @throws XmlPullParserException
     * @throws IOException
     */
    public static String getAppKey(String name) throws XmlPullParserException, IOException {
        String appKey = "";

        List<Config> configs = allConfigs();
        for (Config config : configs) {
            if (config.getName().equalsIgnoreCase(name)) {
                appKey = config.getAppKey();
            }
        }
        return appKey;
    }

    /**
     * 返回所有的配置信息列表
     *
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     */
    public static List<Config> allConfigs() throws XmlPullParserException, IOException {
        List<Config> configs = new ArrayList<>();

        Resources resources = mContext.getResources();
        InputStream inputStream = resources.openRawResource(R.raw.config);
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(inputStream, "utf-8");

        int type = parser.getEventType();
        Config config = null;
        while (type != XmlPullParser.END_DOCUMENT) {
            if (type == XmlPullParser.START_TAG) { // 开始标签
                if ("config".equals(parser.getName())) { // config 标签开始
                    config = new Config();
                }
                if ("appkey".equals(parser.getName())) {
                    config.setAppKey(parser.nextText());
                }
                if ("name".equals(parser.getName())) {
                    config.setName(parser.nextText());
                }
                if ("AppSecret".equals(parser.getName())) {
                    config.setAppSecret(parser.nextText());
                }
            } else {
                if ("config".equals(parser.getName())) { // config 标签开始
                    configs.add(config);
                }
            }
            type = parser.next();
        }

        return configs;
    }


    /**
     * <name>
     * mob
     * </name>
     * <appkey>
     * 125fd0563b954
     * </appkey>
     * <AppSecret>
     * a7594cc080c5fc58ea4c01db17af15dd
     * </AppSecret>
     */
    public static class Config {
        private String name; // 配置的名称
        private String appKey; // app的key
        private String AppSecret; // app 安全码

        public String getAppKey() {
            return appKey;
        }

        public void setAppKey(String appKey) {
            this.appKey = appKey;
        }

        public String getAppSecret() {
            return AppSecret;
        }

        public void setAppSecret(String appSecret) {
            AppSecret = appSecret;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
