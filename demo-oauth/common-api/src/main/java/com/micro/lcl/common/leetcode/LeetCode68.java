package com.micro.lcl.common.leetcode;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/3/1915:17
 */
public class LeetCode68 {
    public static ListNode reser(ListNode head) {
        ListNode next= null;
        ListNode res= null;
        while(head!=null){
            next=head.next;
            head.next=res;
            res=head;
            head=next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        head.next=n1;
        n1.next = n2;
        System.out.println(head);
        ListNode reser = reser(head);
        System.out.println(reser);
    }
}
