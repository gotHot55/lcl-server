package com.micro.lcl.common.leetcode;

/**
 * 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。
 *
 * @author Administrator
 * @date 2021/2/2414:08
 */
public class LeetCode048 {
    /**
     * 使用异或运算  3^3=0 3^3^6=6
     */
    public static int singleNonDuplicate(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

    /**
     * 使用二分查找法
     * @param nums
     * @return
     */
    public static int singleNonDuplicate2(int[] nums) {
        int low = 0, height = nums.length - 1;
        int mid = (height - low) / 2;
        while (low < height) {
            if (nums[mid] == nums[mid - 1]) {
                if ((mid - low) % 2 != 0) {
                    low = mid + 1;
                    System.out.println("low=" + low + "nums[low]" + nums[low]);
                }else {
                    height = mid - 2;
                    System.out.println("height=" + height + ", nums[height]" + nums[height]);
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((height - mid) % 2 != 0) {
                    height = mid - 1;
                    System.out.println("height=" + height + ", nums[height]" + nums[height]);
                }else {
                    low = mid + 2;
                    System.out.println("low=" + low + ", nums[low]" + nums[low]);
                }
            }
            mid = (height - low) / 2 + low; //二分中间位置
            System.out.println("mid=" + mid + ", nums[mid]:" + nums[mid]);
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3,3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8,9};
        int i = singleNonDuplicate2(nums);
        System.out.println(i);

    }
}
