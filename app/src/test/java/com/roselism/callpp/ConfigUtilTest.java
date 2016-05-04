package com.roselism.callpp;

import com.roselism.callpp.util.ConfigUtil;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Created by simon on 16-5-4.
 */
public class ConfigUtilTest {

    @Test
    public void testGetAppKey() {
        try {
            assertEquals("125fd0563b954", ConfigUtil.getAppKey("mob"));
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
