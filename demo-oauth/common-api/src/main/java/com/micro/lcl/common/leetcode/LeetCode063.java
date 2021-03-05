package com.micro.lcl.common.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。
 * 如果有多对数字的和等于s，则输出任意一对即可。
 *
 * @author Administrator
 * @date 2021/3/311:57
 */
public class LeetCode063 {
    public static int[] equalsTarget(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int[] res = new int[2];
        for (int num : nums) {
            if (map.containsKey(num)) {
                res[0]=num;
                res[1] = map.get(num);
                break;
            }else {
                map.put(target - num, num);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 5, 7, 9};
        int[] ints = equalsTarget(arr, 9);
        System.out.println(Arrays.toString(ints));

    }
}
