package com.roselism.callpp.util;

import java.util.regex.Pattern;

/**
 * Created by simon on 2016/5/1.
 */
public class MatcherUtil {
    public static boolean matchEmail(String email) {
        return Pattern.compile("^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$").
                matcher(email).
                matches();
    }

    public static boolean findEmail(String email) {
        return Pattern.compile("^\\s*\\w+(?:\\.?[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$").
                matcher(email).
                find();
    }
}
