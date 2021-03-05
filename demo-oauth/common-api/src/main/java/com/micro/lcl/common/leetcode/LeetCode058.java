package com.micro.lcl.common.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * @author Administrator
 * @date 2021/3/216:27
 */
public class LeetCode058 {
    public static boolean isPalindrome(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder(chars.length);
        for (char aChar : chars) {
            if ((aChar >= 'A' && aChar <= 'Z') || (aChar >= 'a' && aChar <= 'z') || (aChar >= '0' && aChar <= '9')) {
                sb.append(aChar);
            }
        }
        char[] charArray = sb.toString().toLowerCase().toCharArray();
        int i = 0, j = charArray.length - 1;
        while (i < j) {
            if (charArray[i] != charArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(chars[i])) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(chars[j])) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        boolean b = isPalindrome(str);
        System.out.println(b);
        boolean b1 = isPalindrome2("hello world.dlrow olleh");
        System.out.println(b1);
    }
}
