package com.micro.lcl.common.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * @author Administrator
 * @date 2021/1/2615:29
 */
public class LeetCode006 {
    public static void main(String[] args) {
        int[] array = {3, 5, 11, 4, 6, 15, 2, 7};
        int key = 9;
        int[] sum = twoSum(array, key);
        for (int i : sum) {
            System.out.println(i + "\t");
        }

    }

    public static int[] twoSum(int[] nums, int key) {
        if (nums.length == 0 || nums == null) {
            return new int[]{-1, -1};
        }
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] array=new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(key - nums[i])) {
//                array[0] = map.get(key - nums[i]);
//                array[1] = i;
                array[0] = key - nums[i];
                array[1] = nums[i];
                return array;
            }
            map.put(nums[i], i);
        }
        return array;
    }
}
