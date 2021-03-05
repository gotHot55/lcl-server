package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 * 给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数
 * ，它的出现次数超过数组元素总数的 25%。
 * 请你找到并返回这个整数
 *
 * @author Administrator
 * @date 2021/1/2914:43
 */
public class LeetCode013 {
    public static int findSpecialInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }else {
                map.put(i, 1);
            }
        }

        Integer integer = map.entrySet().stream().filter(x -> x.getValue() > arr.length / 4).findFirst().map(x -> x.getKey()).orElse(-1);
        return integer;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2,2, 2, 3, 6, 6, 6, 7, 10};
        int integer = findSpecialInteger(arr);
        System.out.println("integer = " + integer);
    }
}
