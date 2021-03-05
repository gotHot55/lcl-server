package com.micro.lcl.common.leetcode;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 *
 * @author Administrator
 * @date 2021/2/2611:37
 */
public class LeetCode049 {
    public static boolean search(int[][] matrix, int target) {
        int colLength = matrix[0].length-1;
        int row = 0;
        while (row < matrix.length && colLength >= 0) {
            if (matrix[row][colLength] == target) {
                return true;
            } else if (matrix[row][colLength] > target) {
                colLength--;
            }else {
                row++;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        boolean search = search(matrix, 26);
        System.out.println(search);
    }
}
