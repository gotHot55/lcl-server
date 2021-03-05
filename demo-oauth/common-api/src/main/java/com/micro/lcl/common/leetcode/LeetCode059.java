package com.micro.lcl.common.leetcode;

/**
 * 给定一个非空字符串 s，最多删除一个字符。
 * 判断是否能成为回文字符串。
 *
 * @author 茴香豆
 * @date 2021/3/216:42
 */
public class LeetCode059 {
    public static boolean validPalindrome(String str) {
        char[] chars = str.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (chars[i] != chars[j]) {
                return isPalindrome(chars, i + 1, j) || isPalindrome(chars, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcdefhgfedclba";
        boolean b = validPalindrome(str);
        System.out.println(b);
    }
}
