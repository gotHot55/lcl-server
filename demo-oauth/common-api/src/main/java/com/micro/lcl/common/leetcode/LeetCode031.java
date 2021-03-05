package com.micro.lcl.common.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * @author Administrator
 * @date 2021/2/1814:29
 */
public class LeetCode031 {
    public static int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> arrayList = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(arrayList.toString());
        return arrayList.get(k - 1);
    }

    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            /*if (queue.size() < k || num > queue.peek()) {
                queue.offer(num);
            }
            if (queue.size() > k) {
                queue.poll();
            }*/
            queue.add(num);
            if (queue.size()>k) queue.poll();
            System.out.println("middleState:  "+queue.toString());
        }
        System.out.println(queue.toString());
        return queue.peek();

    }
    public static void main(String[] args) {
        int[] array = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int largest = findKthLargest2(array, 4);
        System.out.println(largest);
        System.out.println(Arrays.toString(array));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : array) {
            queue.add(i);
            System.out.println("middleState: "+queue.toString()+"...");
        }
        System.out.println(queue.toString());
    }
}
