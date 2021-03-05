package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。
 * 找到所有出现两次的元素。
 * 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？
 *
 * @author Administrator
 * @date 2021/2/2214:33
 */
public class LeetCode042 {
    public static List<Integer> findDuplicates(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        System.out.println(maxValue);
        int[] array = new int[maxValue+1];
        for (int num : nums) {
            array[num]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<array.length; i++) {
            if (array[i] == 2) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDuplicates(nums);
        System.out.println(list);
    }
}
