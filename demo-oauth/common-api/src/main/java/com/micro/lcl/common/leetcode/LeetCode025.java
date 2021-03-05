package com.micro.lcl.common.leetcode;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author Administrator
 * @date 2021/2/911:24
 */
public class LeetCode025 {
    public static String commonPrefix(String[] arrString) {
        if (arrString.length == 1) {
            return arrString[0];
        }
        Arrays.sort(arrString);
        System.out.println(Arrays.toString(arrString));
        char[] c1 = arrString[0].toCharArray();
        char[] c2 = arrString[arrString.length - 1].toCharArray();

        int min = Math.min(c1.length, c2.length);
        StringBuilder builder = new StringBuilder(min);
        int index = 0;
        while (index < min) {
            if (c1[index] == c2[index]) {
                builder.append(c1[index]);
            }else {
                break;
            }
            index++;
        }
        return builder.toString();
    }

    public static String commonPrefix2(String[] strs) {
        String maxPrefix = strs[0];
        int firstLen = maxPrefix.length();
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < firstLen; j++) {
                maxPrefix = strs[0].substring(0, j + 1);
                if (!strs[i].startsWith(maxPrefix)) {
                    maxPrefix = maxPrefix.substring(0, j);
                    firstLen = maxPrefix.length();
                    break;
                }
            }
            if (firstLen == 0) {
                return maxPrefix;
            }
        }
        return maxPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"baaabb", "babbbbbb", "baabbbbbbbbbbbb"};
        String s = commonPrefix2(strs);
        System.out.println(s);
    }
}
