package com.micro.lcl.common.leetcode;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author Administrator
 * @date 2021/3/816:23
 */
public class LeetCode066 {
    public static int findKMax(int[] nums, int k) {
        Sort.shellSort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int kMax = findKMax(nums, 4);
        System.out.println(kMax);
    }
}
