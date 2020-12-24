package com.c611.classProject.Utils;

/**
 * 字符串工具类
 * @author llz
 * @version 1.0
 * @date 2020/12/23 21:20
 */
public class StringUtils {

    private StringUtils() {
    }

    /**
     * 判断字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

}
