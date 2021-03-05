package com.micro.lcl.common.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author Administrator
 * @date 2021/2/2014:55
 */
public class LeetCode038 {
    public static int[] onceTwo(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>(nums.length);
        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            }else {
                hashSet.add(num);
            }
        }
        return hashSet.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] onceTwo2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> list = hashMap.entrySet().stream().filter(p -> p.getValue() == 1).collect(Collectors.toList())
                .stream().map(Map.Entry::getKey).collect(Collectors.toList());
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6, 8, 7, 9, 0, 9, 8, 7, 4, 2, 5, 0};
//        int[] two2 = onceTwo2(arr);
//        System.out.println(Arrays.toString(two2));
//        int[] two = onceTwo(arr);
//        System.out.println(Arrays.toString(two));
//        List list = new ArrayList();
        // 1010 >>1 = 0101   1111<<1=11110
        int a = 10 <<2;
        System.out.println(a);
    }
}
