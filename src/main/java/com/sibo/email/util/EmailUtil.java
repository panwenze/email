package com.sibo.email.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 邮箱工具
 * @author: panwz
 * @create: 2018-11-21 16:50
 **/

public class EmailUtil {
    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(string);
        if (m.matches())
            return true;
        else
            return false;
    }
}
