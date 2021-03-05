package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * @author Administrator
 * @date 2021/2/2014:47
 */
public class LeetCode037 {
    public static int onlyOneValue(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.entrySet().stream().filter(t -> t.getValue() == 1).findFirst().get().getKey();

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 2, 3, 4, 5, 5};
        int value = onlyOneValue(arr);
        System.out.println(value);
    }
}
