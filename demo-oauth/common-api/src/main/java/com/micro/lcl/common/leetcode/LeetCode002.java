package com.micro.lcl.common.leetcode;

import com.google.common.base.Joiner;

import java.util.Collections;

/**
 * 实现一个函数，把字符串 s 中的每个空格替换成"%20"
 *
 * @author Administrator
 * @date 2021/1/269:52
 */
public class LeetCode002 {
    public static final Joiner joiner = Joiner.on(" ").useForNull("%20");
    public static String replace(String str) {
        if (str == null) {
            return null;
        }
        char[] chars = str.toCharArray();
        System.out.println(chars);
        StringBuilder sb = new StringBuilder();

//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == ' ') {
//                sb.append("%20");
//            }else {
//                sb.append(str.charAt(i));
//            }
//
//        }
        for (char c : chars) {
            if (c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcd f  hij  m n p o";
        String s1 = replace(s);
        System.out.println(s1);

    }
}
