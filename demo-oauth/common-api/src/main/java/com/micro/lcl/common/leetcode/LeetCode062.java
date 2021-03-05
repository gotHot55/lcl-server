package com.micro.lcl.common.leetcode;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target
 * ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 *
 * @author 使用二分查找
 * @date 2021/3/311:43
 */
public class LeetCode062 {
    public static int searchTarget(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int left=0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right-left) / 2+left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 2, 4, 5, 6, 7, 9, 11, 12, 14, 17, 19, 25,33};
        int i = searchTarget(nums, 0);
        System.out.println(i);
    }
}
