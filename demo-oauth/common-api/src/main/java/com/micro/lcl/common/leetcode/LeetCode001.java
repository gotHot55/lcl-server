package com.micro.lcl.common.leetcode;

/**
 * LeetCode001|统计位数为偶数的数字
 *
 * @author Administrator
 * @date 2021/1/2518:00
 */
public class LeetCode001 {
    public static int findNums(int[] nums) {
        if (nums.length == 0 || "".equals(nums)) {
            return 0;
        }
        int find = 0;
        for (int num : nums) {
            if (String.valueOf(num).length() % 2 == 0) {
                find += 1;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{111, 2222, 1221, 122, 4343, 54646};
        int i = findNums(nums);
        System.out.println(i);
    }
}
