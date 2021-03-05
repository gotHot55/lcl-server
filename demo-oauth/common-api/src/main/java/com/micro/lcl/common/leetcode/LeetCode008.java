package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * @author Administrator
 * @date 2021/1/279:54
 */
public class LeetCode008 {
    public static List<Integer> onlyNum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<Integer>(nums.length);
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }else {
                map.put(num, map.get(num) + 1);
            }
        }
        System.out.println("map: " + map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 2, 1, 2, 3};
        List<Integer> list = onlyNum(nums);
        System.out.println(list);
    }
}
