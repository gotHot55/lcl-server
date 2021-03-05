package com.micro.lcl.common.leetcode;

/**
 * 合并两个排序的链表
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @author Administrator
 * @date 2021/1/2610:38
 */
public class LeetCode004 {
    public static ListNode mergeTwo(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        ListNode listNode = new ListNode(-1);
        ListNode tail = listNode;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        tail.next = head1 == null ? head2 : head1;
        return listNode.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node14 = new ListNode(4);
        ListNode node24 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head1.next = node2;
        node2.next = node14;
        head2.next = node3;
        node3.next = node24;
        System.out.println(head1);
        System.out.println(head2);
        ListNode two = mergeTwo(head1, head2);
        System.out.println(two);

    }
}
