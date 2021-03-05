package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组中占比超过一半的元素称之为主要元素。
 * 给定一个整数数组，找到它的主要元素。
 * 若没有，返回-1。
 *
 * @author Administrator
 * @date 2021/2/711:44
 */
public class LeetCode019 {

    public static int searchMain(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>(arr.length);
        for (int i : arr) {
            if (hashMap.containsKey(i)) {
                hashMap.put(i, hashMap.get(i) + 1);
            }else {
                hashMap.put(i, 1);
            }
        }
        return hashMap.entrySet().stream().filter(f -> f.getValue() >= arr.length / 2).findFirst().map(Map.Entry::getKey).orElse(-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9, 3, 9, 3, 5, 5};
        int i = searchMain(arr);
        System.out.println(i);
    }
}
