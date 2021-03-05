package com.micro.lcl.common.leetcode;

/**
 * 给你一个数组 nums 和一个值 val，
 * 你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *
 * @author Administrator
 * @date 2021/1/279:35
 */
public class LeetCode007 {
    public static int remove(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int result=0;
        for (int num : nums) {
            if (num != val) {
                nums[result] = num;
                result++;
            }
        }
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i]+",");
        }
        System.out.println("\t");
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 2,5,3,2,21,432,43,654,3423,12,44,22,3};
        int remove = remove(nums, 2);
        System.out.println(remove);
    }
}
