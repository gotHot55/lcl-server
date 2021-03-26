package com.micro.lcl.common.leetcode;


import java.util.Arrays;

/**
 * 排序
 *
 * @author Administrator
 * @date 2021/2/111:16
 */
public class Sort {
    /**
     * 选择排序
     */
    public static void SelectorSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int temp = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
           int index = i;
            for (int j = i+1; j < nums.length; j++) {
//                temp = nums[index] < nums[j] ? nums[index] : nums[j];
                index = nums[index] < nums[j] ? index : j;
                count++;
            }
            temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
            System.out.println(Arrays.toString(nums));
        }
        System.out.println("执行次数:"+count);
    }

    /**
     * 冒泡排序
     */
    public static void BubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 直接插入排序
     */
    public static void InsertionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] <= nums[j - 1]) {
                    temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
//            System.out.println(Arrays.toString(nums));
        }
    }

    /**
     * 快速排序
     */
    public static void QuickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int start = 0;
        int end = nums.length - 1;
        midStatus(nums, start, end);
    }

    private static void midStatus(int[] nums,int start,int end) {
        if (start < end) {
            int left = start;
            int right = end;
            int temp = nums[start];
            while (left < right) {
                while (left < right && nums[right] > temp) {
                    right--;
                }
                nums[left] = nums[right];
//                left++;
                while (left < right && nums[left] <= temp) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = temp;
            System.out.println(Arrays.toString(nums));
            midStatus(nums, start, left);
            midStatus(nums, left+1, end);
        }
    }

    /**
     * 归并排序
     */
    public static void Merge(int[] arr) {
        int low = 0;
        int height = arr.length - 1;
        Merge(arr,low,height);
    }

    public static void Merge(int[] arr, int low, int height) {
        int center = (low + height) / 2;
        if (low < height) {
            Merge(arr, low, center);
            Merge(arr, center + 1, height);
            MergeSort(arr, low, center, height);
            System.out.println(Arrays.toString(arr));
        }

    }

    private static void MergeSort(int[] arr, int low, int center, int height) {
        int[] tempArr = new int[arr.length];
        int i = low, j = center + 1;
        int index = 0;
        while (i <= center && j <= height) {
            if (arr[i] < arr[j]) {
                tempArr[index] = arr[i];
                i++;
            }else {
                tempArr[index] = arr[j];
                j++;
            }
            index++;
        }
        while (i <= center) {
            tempArr[index++] = arr[i];
            i++;
        }
        while (j <= height) {
            tempArr[index++] = arr[j];
            j++;
        }
        for (int k = 0; k < index; k++) {
            arr[k + low] = tempArr[k];
        }
    }

    /**
     * 基数排序
     */
    public static void BaseSort(int[] arr) {
        int maxLength = 0;
        for (int num : arr) {
            if (maxLength < num) {
                maxLength = num;
            }
        }
        maxLength = String.valueOf(maxLength).length();
        int[][] temp = new int[10][arr.length];
        int[] count = new int[10];
        int num = 0;
        int index = 0;
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                num = arr[j] / n % 10;
                temp[num][count[num]] = arr[j];
                count[num]++;

            }
            for (int j = 0; j < count.length; j++) {
                for (int k = 0; k < count[j]; k++) {
                    arr[index] = temp[j][k];
                    index++;
                }
                count[j] = 0;
            }
            index = 0;
        }

    }
    /**
     * 希尔排序
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp;
        for (int i = arr.length / 2; i > 0; i /= 2) {
            for (int j = i; j < arr.length; j++) {
                for (int k = j - i; k >= 0; k-=i) {
                    if (arr[k] > arr[k + 1]) {
                        temp = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = temp;
//                        System.out.println(Arrays.toString(arr));
                    }
                }
            }
        }
    }

    /**
     * 堆排序
     * @param arr
     */
    public static void HeapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maximumHeap(arr, i);
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            swap(arr, 0, i);
            maximumHeap(arr, 0);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void maximumHeap(int[] arr, int i) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < arr.length; j = j * 2 + 1) {
            if (j + 1 < arr.length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }



    public static void main(String[] args) {
        int[] nums = {4,6,8,5,9};
        System.out.println(Arrays.toString(nums));
//        SelectorSort(nums);
//        BubbleSort(nums);
//        InsertionSort(nums);
        QuickSort(nums);
//        Merge(nums);
//        BaseSort(nums);
//        shellSort(nums);
//        HeapSort(nums);
        System.out.println(Arrays.toString(nums));

    }
}

/**
 * 交换数字的三种方法：临时变量法、算术法、位运算法。
 */
class Swap{
    /**
     * 临时变量法
     * @param arr 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swapByTemp(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]= arr[j];
        arr[j] = arr[i];
    }

    /**
     * 通过算术法交换数组array的i和j位置的数据（有可能溢出）
     * @param arr 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swapByArithmetic(int[] arr, int i, int j) {
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] = arr[j];
    }

    /**
     * 通过位运算法交换数组array的i和j位置的数据
     * @param arr 数组
     * @param i 下标i
     * @param j 下标j
     */
    public static void swapByBitOperation(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j]; //i^j^j=i
        arr[i] = arr[i] ^ arr[j];//i^j^i=j
    }
}