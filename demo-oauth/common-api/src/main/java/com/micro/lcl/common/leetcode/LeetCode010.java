package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @author Administrator
 * @date 2021/1/2814:24
 */
public class LeetCode010 {
    public static List<Integer> intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>(nums1.length > nums2.length ? nums2.length : nums1.length);
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (num1 == num2) {
                    if (!list.contains(num1)) {
                        list.add(num1);
                    }
                }
            }
        }
        return list;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return null;
        }
        HashSet<Integer> set1 = new HashSet<>(nums1.length);
        HashSet<Integer> set2 = new HashSet<>(nums2.length);
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            set2.add(num2);
        }
        set1.retainAll(set2);
        int[] result = new int[set1.size()];
        int i = 0;
        for (Integer integer : set1) {
            result[i++] = integer;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 1, 2};
        int[] nums2 = {2, 2};
        List<Integer> list = intersection1(nums1, nums2);
        System.out.println(list);
        int[] ints = intersection2(nums1, nums2);
        for (int i : ints) {
            System.out.print(i+"\t");
        }
    }
}
