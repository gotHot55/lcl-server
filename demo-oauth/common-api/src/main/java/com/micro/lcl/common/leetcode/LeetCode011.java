package com.micro.lcl.common.leetcode;

/**
 * 设计一个算法，找出数组中最小的k个数。
 *
 * 以任意顺序返回这k个数均可。
 *
 * @author Administrator
 * @date 2021/1/2814:51
 */
public class LeetCode011 {
    public static int[] sort(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    public static int[] findMinK(int[] nums, int k) {

        int[] result = new int[k];
        int[] sort = sort(nums);
        for (int i = 0; i < k; i++) {
            result[i] = sort[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 8, 3, 7, 2, 9, 4, 5};
        System.out.println("\n-----------num1------------------");
        for (int num : nums) {
            System.out.print(num + "\t");
        }
        System.out.println("\n-----------num2------------------");
        int[] sort = findMinK(nums,7);
        for (int num : nums) {
            System.out.print(num+"\t");
        }
        System.out.println("\n-----------sort------------------");
        for (int i : sort) {
            System.out.print(i + "\t");
        }
        System.out.println("\n-----------is-----------------");
        int[] is = new int[4];
        System.arraycopy(nums, 0, is, 0, is.length);
        for (int i : is) {
            System.out.print(i+"\t");
        }
    }
}
