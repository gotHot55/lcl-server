package com.micro.lcl.common.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false
 *
 * @author 采用二分法
 * @date 2021/2/2411:29
 */
public class LeetCode047 {
    public static boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid = 0;

        while (l <= r) {
            while (l < r && nums[l] == nums[l+1]) l++;
            while (l < r && nums[r] == nums[r - 1]) r--;
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && nums[mid] >= target) {
                    r = mid - 1;
                } else l = mid + 1;
            } else {
                if (target >= nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                } else r = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        boolean search = search(nums, 5);
        System.out.println(search);
    }
}
