package com.micro.lcl.common.leetcode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * @author Administrator
 * @date 2021/3/216:59
 */
public class LeetCode060 {

    public static boolean isPalindrome(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }

        ListNode p = slow;
        ListNode pre = null;
        System.out.println(slow);
        while (p != null) {
            ListNode temp = p.next;
            p.next = pre;
            pre = p;
            p = temp;
        }
        System.out.println(head);
        System.out.println(pre);
        while (pre != null) {
            if (head.val == pre.val) {
                head = head.next;
                pre = pre.next;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode slow = new ListNode(1);
        ListNode q = new ListNode(2);
        ListNode w = new ListNode(3);
        ListNode e = new ListNode(3);
        ListNode r = new ListNode(1);
        slow.next = q;
        q.next = w;
        w.next = e;
        e.next=r;
        System.out.println(slow);
        boolean palindrome = isPalindrome(slow);
        System.out.println(palindrome);
    }
}
