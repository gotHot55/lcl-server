package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * @author Administrator
 * @date 2021/3/114:33
 */
public class LeetCode057 {
    public static List<Integer> addToArrayFrom(int[] arr, int k) {
        StringBuilder sb = new StringBuilder(arr.length);
        for (int i : arr) {
            sb.append(i);
        }
        String str1 = sb.toString();
        String str2 = String.valueOf(k);
        List<Integer> res = new ArrayList<>();
        StringBuilder mid = new StringBuilder();

        int s1len = str1.length() - 1;
        int s2len = str2.length() - 1;
        int carry = 0;
        while (s1len >= 0 || s2len >= 0 || carry > 0) {
            if (s1len >= 0) {
                carry += (str1.charAt(s1len) - '0');
                s1len--;
            }
            if (s2len >= 0) {
                carry += (str2.charAt(s2len) - '0');
                s2len--;
            }
            mid.append(carry % 10);
            carry /= 10;
        }
        char[] chars = mid.reverse().toString().toCharArray();
        //        String s = LeetCode056.addStr(str1, str2);
        for (char aChar : chars) {
            res.add(aChar-'0');
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int k = 1;
        List<Integer> list = addToArrayFrom(A, k);
        System.out.println(list);
    }
}
