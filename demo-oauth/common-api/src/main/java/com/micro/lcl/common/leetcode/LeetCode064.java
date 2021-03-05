package com.micro.lcl.common.leetcode;

/**
 * 数组nums包含从0到n的所有整数，但其中缺了一个。
 * 请编写代码找出那个缺失的整数。
 * 你有办法在O(n)时间内完成吗？
 *
 * @author Administrator
 * @date 2021/3/314:19
 */
public class LeetCode064 {
    public static int missNum(int[] arr) {
        int[] temp = new int[arr.length + 1];
        for (int i : arr) {
            temp[i]++;
        }
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] re = {3, 0, 1};
        int i = missNum(re);
        System.out.println(i);
    }
}
