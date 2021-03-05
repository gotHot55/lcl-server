package com.micro.lcl.common.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 *
 * @author Administrator
 * @date 2021/3/314:33
 */
public class LeetCode065 {
    public static int[] smallestK(int[] arr, int k) {
        Sort.QuickSort(arr);
        int[] res = new int[k];
        if (k >= 0) {
            System.arraycopy(arr, 0, res, 0, k);
        }
        return res;
    }

    public static int[] smallestK2(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Integer::compareTo);
        for (int i : arr) {
            queue.add(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 2, 4, 6, 8};
        int k = 4;
        int[] smallestK = smallestK(arr, 5);
        System.out.println(Arrays.toString(smallestK));

    }
}
