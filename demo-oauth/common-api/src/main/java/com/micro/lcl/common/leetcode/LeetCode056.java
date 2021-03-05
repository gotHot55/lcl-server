package com.micro.lcl.common.leetcode;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * @author 字符串相加
 * @date 2021/3/114:10
 */
public class LeetCode056 {
    public static void main(String[] args) {
        String str = "123";
        String str2 = "789";
        String addStr = addStr(str, str2);
        System.out.println(addStr);

    }

    public static String addStr(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int n1len = num1.length() - 1;
        int n2len = num2.length() - 1;
        int array = 0;
        while (n1len >= 0 || n2len >= 0 || array > 0) {
            if (n1len >= 0) {
                array += (num1.charAt(n1len) - '0');
                n1len-=1;
            }
            if (n2len >= 0) {
                array += (num2.charAt(n2len) - '0');
                n2len-=1;
            }
            sb.append(array%10);
            array /= 10;
        }
        return sb.reverse().toString();
    }
}
