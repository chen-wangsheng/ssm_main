package com.hbeu.ssm.utils;

import java.io.UnsupportedEncodingException;

/**
 * @author 陈旺生
 * @create 2019-11-25 10:29
 */
public class EncodingUtil {
    public static String encodeStr(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
