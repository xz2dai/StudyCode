package com.xz2dai.OA_demo.Utils;

/**
 * @author ：yq
 * @description：字符串工具类
 * @date ：2020/12/17 10:57
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
