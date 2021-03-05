package com.micro.lcl.common.leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * @author Administrator
 * @date 2021/2/2314:39
 */
public class LeetCode046 {
    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && nums[start] < nums[mid]) {
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }else {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int search2(int[] nums,int target) {
        int[] newNums = new int[nums.length];
        System.arraycopy(nums, 0, newNums, 0, nums.length);
        System.out.println(Arrays.toString(newNums));
        return IntStream.range(0, newNums.length).filter(t -> newNums[t] == target).findFirst().orElse(-1);
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int search = search(nums, 0);
        System.out.println(search);
    }
}
