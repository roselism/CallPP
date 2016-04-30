package com.roselism.callpp.util.io;


import com.roselism.callpp.util.convert.InStream2String;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 读取流的工具
 * Created by simon on 2016/4/26.
 *
 * @author Simon Wang
 * @version 1.0
 */
public class StreamUtil {

    /**
     * 输入流与String 之间的转换
     *
     * @param in
     * @return
     * @throws IOException
     * @since 1.0
     */
    public static String Stream2String(final InputStream in) throws IOException {
        return new InStream2String().convert(in);
    }

    /**
     * 需要的时候再实现
     * 输出流转输入流
     *
     * @return 返回输出流
     * @since 1.0
     */
    private static OutputStream input2Output() {
        return null;
    }

}
