package com.roselism.callpp.local.sortstrategy;

import android.support.annotation.NonNull;

import com.roselism.callpp.local.bean.ContactInfo;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Comparator;

/**
 * @创建者 lai
 * @创建时间 2016/5/3
 * @packageName com.roselism.callpp.model
 * @更新时间 2016/5/3 23:23
 * @描述 按照拼音比较进行排序
 */
public class ChineseComparator implements Comparator<ContactInfo> {

    @Override
    public int compare(@NonNull ContactInfo lhs, @NonNull ContactInfo rhs) {
        String lhsPinyin = PinYinUtil.getPinYin(lhs.getDisplayName());//获取联系人姓名的拼音
        String rhsPinYin = PinYinUtil.getPinYin(rhs.getDisplayName());
        return lhsPinyin.compareTo(rhsPinYin);
    }

    /**
     * 汉字转拼音类的工具类
     */
    private static class PinYinUtil {
        /**
         * 将字符串中的中文转化为拼音,其他字符不变
         *
         * @param inputString
         *
         * @return
         */
        public static String getPinYin(String inputString) {
            HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
            format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
            format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            format.setVCharType(HanyuPinyinVCharType.WITH_V);

            char[] input = inputString.trim().toCharArray();
            String output = "";

            try {
                for (int i = 0; i < input.length; i++) {
                    if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
                        String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
                        output += temp[0];
                    } else
                        output += java.lang.Character.toString(input[i]);
                }
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
            return output;
        }

        /**
         * 汉字转换位汉语拼音首字母，英文字符不变
         *
         * @param chines 汉字
         *
         * @return 拼音
         */
        public static String converterToFirstSpell(String chines) {
            String pinyinName = "";
            char[] nameChar = chines.toCharArray();
            HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
            defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
            defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
            for (int i = 0; i < nameChar.length; i++) {
                if (nameChar[i] > 128) {
                    try {
                        pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0].charAt(0);
                    } catch (BadHanyuPinyinOutputFormatCombination e) {
                        e.printStackTrace();
                    }
                } else {
                    pinyinName += nameChar[i];
                }
            }
            return pinyinName;
        }
    }
}
