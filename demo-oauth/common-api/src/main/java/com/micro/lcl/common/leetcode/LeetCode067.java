package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @author Administrator
 * @date 2021/3/816:30
 */
public class LeetCode067 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entryList = map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
        return IntStream.range(0, k).map(t -> entryList.get(t).getKey()).toArray();
    }
}
