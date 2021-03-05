package com.micro.lcl.common.leetcode;

/**
 * 给定两个排序后的数组 A 和 B，
 * 其中 A 的末端有足够的缓冲空间容纳 B。编写一个方法，将 B 合并入 A 并排序。
 *
 * @author Administrator
 * @date 2021/1/299:36
 */
public class LeetCode012 {
    public static void merge(int[] A, int m, int[] B, int n) {
        int[] temp = new int[m + n];
        int index = 0;
        int ai = 0;
        int bi = 0;
        while (ai < m && bi < n) {
            temp[index++] = A[ai] < B[bi] ? A[ai++] : B[bi++];
        }
        while (ai < m) {
            temp[index++] = A[ai++];
        }
        while (bi < n) {
            temp[index++] = B[bi++];
        }
        System.arraycopy(temp, 0, A, 0, index);

    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] B = {2, 5, 6};
        int n = 3;
        merge(A, m, B, n);
        for (Integer num : A
        ) {
            System.out.print(num + "\t");
        }
    }
}
