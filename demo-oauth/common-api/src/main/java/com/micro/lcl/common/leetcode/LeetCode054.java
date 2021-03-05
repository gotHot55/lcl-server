package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 * 返回重复了 N 次的那个元素。
 *
 * @author 重复N次的元素
 * @date 2021/3/111:41
 */
public class LeetCode054 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 5, 2, 5, 3, 5, 4};
        int i = returnRepeatN(arr);
        int n2 = returnRepeatN2(arr);
        System.out.println(i + "," + n2);
    }

    public static int returnRepeatN(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (!set.add(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int returnRepeatN2(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.entrySet().stream().filter(p -> p.getValue() > 1).findFirst().get().getKey();
    }
}
