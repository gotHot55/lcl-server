package com.micro.lcl.common.leetcode;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * @author Administrator
 * @date 2021/2/109:59
 */
public class LeetCode028 {
    public static int[] printDecimal(int n) {
        if (n<=0) {
            return new int[]{0};
        }
//        int len = decimal(10, n) - 1;
        double len = Math.pow(10, n) - 1;
        System.out.println(len);
        int[] result = new int[(int) len];
        for (int i = 0; i < len; i++) {
            result[i] = i + 1;
        }
        return result;
    }

    public static int decimal(int num,int pow) {
        if (pow == 1) {
            return num;
        }
        pow--;
        return num * decimal(num, pow);
    }

    public static void main(String[] args) {
        int decimal = decimal(10,2);
        System.out.println(decimal);
//        final int[] ints = printDecimal(1);
//        System.out.println(Arrays.toString(ints));

    }
}
