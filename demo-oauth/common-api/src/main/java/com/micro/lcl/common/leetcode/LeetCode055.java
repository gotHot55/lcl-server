package com.micro.lcl.common.leetcode;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * @author Administrator
 * @date 2021/3/114:02
 */
public class LeetCode055 {
    public static void reverse(char[] charArr) {
        int length = charArr.length;
        for (int i = 0; i < length >> 1; i++) {
            char temp = charArr[i];
            charArr[i] = charArr[length - i - 1];
            charArr[length - i - 1] = temp;
        }
//        return charArr;
    }

    public static void main(String[] args) {
        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));

    }
}
