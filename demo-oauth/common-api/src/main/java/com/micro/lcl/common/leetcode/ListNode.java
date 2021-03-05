package com.micro.lcl.common.leetcode;

import cn.hutool.core.lang.tree.TreeNode;

/**
 * 链表
 *
 * @author Administrator
 * @date 2021/1/2610:10
 */
public class ListNode {
    int val;
    ListNode next; // 下一个链表对象
    ListNode(int x) { //赋值链表的值
        val = x;
    }

    @Override
    public String toString() {
        if (next == null) {
            return String.valueOf(val);
        }
//         node = new ListNode(-1);
        ListNode node = next;
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        while (node != null) {
            sb.append("->"+node.val);
            node = node.next;
        }
        return sb.toString();
//        return "ListNode{" +
//                "val=" + val +
//                ", next=" + next +
//                '}';
    }

}
