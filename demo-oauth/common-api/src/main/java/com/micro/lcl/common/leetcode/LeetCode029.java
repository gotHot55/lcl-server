package com.micro.lcl.common.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素
 *
 * @author Administrator
 * @date 2021/2/1010:19
 */
public class LeetCode029 {
    public static int[] rateKHeight(int[] arr,int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }
        final List<Map.Entry<Integer, Integer>> entryList = map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
        System.out.println(entryList);
        return IntStream.range(0, k).map(i -> entryList.get(i).getKey()).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        final int[] ints = rateKHeight(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
