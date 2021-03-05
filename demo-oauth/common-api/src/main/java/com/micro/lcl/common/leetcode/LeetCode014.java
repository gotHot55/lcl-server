package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，
 * 它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author Administrator
 * @date 2021/1/2915:11
 */
public class LeetCode014 {
    public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
        ListNode dummyNode = new ListNode(0);
        ListNode result = dummyNode;
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        int temp = 0;
        while (node1 != null || node2 != null || temp != 0) {
            if (node1 != null) {
                temp += node1.val;
                node1 = node1.next;
            }
            if (node2 != null) {
                temp += node2.val;
                node2 = node2.next;
            }
            dummyNode.next = new ListNode(temp % 10);
            temp /= 10;
            dummyNode = dummyNode.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);

        l1.next = l12;
        l12.next = l13;
//        l13.next = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l2.next = l22;
        l22.next = l23;
        System.out.println(l1);
        System.out.println("+");
        System.out.println(l2);
        System.out.println("=");
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println("listNode = " + listNode);
    }
}
