package com.micro.lcl.common.leetcode;

/**
 * 实现一种算法，找出单向链表中"倒数"第 k 个节点。
 * 输入：1->2->3->4->5 和 k = 2
 * 输出：4
 * @author Administrator
 * @date 2021/1/2610:06
 */
public class LeetCode003 {
    public static int findK(ListNode head, int k) {
        if (head == null) {
            return 0;
        }
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while (p != null) {
            p = p.next;
            head = head.next;
        }
        return head.val;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(node1);
        int s = findK(node1, 2);
        System.out.println(s);

    }
}
