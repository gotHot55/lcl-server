package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Todo
 *给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * @author Administrator
 * @date 2021/2/1814:05
 */
public class LeetCode030 {
    public static int findDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<Integer>(arr.length);
        for (int i : arr) {
            boolean add = set.add(i);
            if (!add) {
                return i;
            }
        }
        return 0;
    }

    public static int findDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet().stream().filter(f -> f.getValue() > 1).findFirst().get().getKey();
    }

    public static int findDuplicate3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            }else {
                map.put(num, 1);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int i = findDuplicate(nums);
        System.out.println(i);
        int i2 = findDuplicate2(nums);
        System.out.println(i2);
        int i3 = findDuplicate3(nums);
        System.out.println(i3);
    }
}
