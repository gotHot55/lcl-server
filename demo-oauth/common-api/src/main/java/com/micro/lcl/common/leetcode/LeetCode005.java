package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。
 *
     输入:
     [
     1->4->5,
     1->3->4,
     2->6
     ]
     输出: 1->1->2->3->4->4->5->6
 *
 * @author Administrator
 * @date 2021/1/2614:10
 */
public class LeetCode005 {
    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(2);
        ListNode l32 = new ListNode(6);
        l31.next = l32;
        ListNode[] listNodes = {l11, l21, l31};
        ListNode node = mergeLists(listNodes);
        System.out.println(node);
    }

    private static ListNode mergeLists(ListNode[] listNodes) {
        if (listNodes == null || listNodes.length == 0) {
            return null;
        }

        //使用上一个合并两个链表
//        for (ListNode listNode : listNodes) {
//            if (node.next == null) {
//                node = listNode;
//            }else {
//                LeetCode004.mergeTwo(node, listNode);
//            }
//        }
        List<Integer> lists = new ArrayList<>();
        for (ListNode listNode : listNodes) {
            ListNode temp = listNode;
            while (temp != null) {
                lists.add(temp.val);
                temp = temp.next;
            }
        }
        Collections.sort(lists);
        ListNode node = new ListNode(-1);
        ListNode tail = node;
        for (Integer integer : lists) {
            tail.next = new ListNode(integer);
            tail = tail.next;
        }
        return node.next;
    }
}
