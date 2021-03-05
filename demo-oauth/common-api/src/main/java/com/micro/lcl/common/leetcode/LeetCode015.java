package com.micro.lcl.common.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 * @author Administrator
 * @date 2021/1/2915:32
 */
public class LeetCode015 {
    public static void delNum(ListNode head, int val) {
        ListNode node = head;

        ListNode dummyNode = new ListNode(0);
        ListNode tempNode = dummyNode;
        //方法一
        /*while (node != null) {
            if (node.val != val) {
                tempNode.next = new ListNode(node.val);
                tempNode = code1.next;
            }
            node = node.next;
        }

        */

        //方法二
        HashSet<Integer> hashSet = new LinkedHashSet<>();
        while (node != null) {
            if (node.val != val) {
                hashSet.add(node.val);
            }
            node = node.next;
        }
        for (Integer number : hashSet) {
            tempNode.next = new ListNode(number);
            tempNode = tempNode.next;
        }

        System.out.println(tempNode);
        head = dummyNode.next;
        System.out.println(head);
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(l1);

        delNum(l1, 5);
    }
}
