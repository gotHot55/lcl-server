package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，
 * 判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请你找出所有满足条件且不重复的三元组。
 *
 * @author Administrator
 * @date 2021/2/2311:56
 */
public class LeetCode045 {
    public static List<List<Integer>> search(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[L] + nums[i] + nums[R];
                if (sum == 0) {
                    listList.add(Arrays.asList(nums[L], nums[i], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }
                else if(sum > 0) R--;
                else if (sum < 0) L++;
            }
        }
        return listList;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> search = search(nums);
        System.out.println(search);
    }
}
