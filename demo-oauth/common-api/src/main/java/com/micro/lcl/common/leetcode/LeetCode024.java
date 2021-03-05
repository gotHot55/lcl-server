package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 *
 * @author Administrator
 * @date 2021/2/811:54
 */
public class LeetCode024 {
    public static boolean palindrome(ListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        int start = 0;
        int end = list.size() - 1;
        System.out.println(list);
        while (start <= end) {
            System.out.println("start:" + list.get(start) + "end:" + list.get(end));
            if (!list.get(start).equals(list.get(end))) {
                return false;
            }else {
                start++;
                end--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);

        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        System.out.println(l1);
        boolean palindrome = palindrome(l1);
        System.out.println(palindrome);
    }
}
