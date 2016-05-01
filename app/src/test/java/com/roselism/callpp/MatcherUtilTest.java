package com.roselism.callpp;

import com.roselism.callpp.util.MatcherUtil;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by simon on 2016/5/1.
 */
public class MatcherUtilTest {

    @Test
    public void matchEmail_test() {
        assertEquals(true, MatcherUtil.matchEmail("wangzhen961681117@gmail.com"));
        assertEquals(true, MatcherUtil.matchEmail("hero21c@outlook.com"));
        assertEquals(true, MatcherUtil.matchEmail("hero21c@safd.com"));


        assertEquals(false, MatcherUtil.matchEmail("wangzhen96168111l.com"));
        assertEquals(false, MatcherUtil.matchEmail("wanghzne"));
        assertEquals(false, MatcherUtil.matchEmail("123465798adsfjafijiaosdfjj@@@"));

    }
}
