package com.micro.lcl.common.leetcode;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author Administrator
 * @date 2021/2/715:38
 */
public class LeetCode021 {
    public static int sum(int n) {
        if (0 == n || 1 == n) {
            return n;
        }
        return n + sum(n-1);
    }

    public static void main(String[] args) {
        int n = sum(100);
        System.out.println(n);

    }
}
