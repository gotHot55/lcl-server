package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 *
     输入: 4->2->1->3
     输出: 1->2->3->4
 * @author Administrator
 * @date 2021/2/110:37
 */
public class LeetCode016 {
    public static void listNodeSort(ListNode listNode) {
        ListNode temp = listNode;
        List<Integer> list = new ArrayList<>();
        while (temp!= null) {
            list.add(temp.val);
            temp = temp.next;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        System.out.println(Arrays.toString(arr));
        Sort.InsertionSort(arr);
        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
            if (listNode != null) {
                listNode.val = i;
                listNode = listNode.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(1);
        ListNode node2= new ListNode(3);
        ListNode node3 = new ListNode(2);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        System.out.println(node);
        listNodeSort(node);
        System.out.println(node);

    }
}
