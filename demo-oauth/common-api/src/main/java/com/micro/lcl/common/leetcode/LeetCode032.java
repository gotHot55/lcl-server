package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出一个完全二叉树，求出该树的节点个数。
 *
 * @author Administrator
 * @date 2021/2/1910:02
 */
public class LeetCode032 {
    public static int countNodes(TreeNode treeNode) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(treeNode);
        List<Integer> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        String str = "3,2,5,null,8,12";
        TreeNode treeNode = TreeNode.mkTree(str);
        System.out.println(treeNode);
        int nodes = countNodes(treeNode);
        System.out.println(nodes);
    }
}
