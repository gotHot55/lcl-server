package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，
 * 同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * @author Administrator
 * @date 2021/2/714:31
 */
public class LeetCode020 {
    public static  List<List<Integer>> printBinaryTree(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> listList = new ArrayList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                list.add(node.val);
            }
            listList.add(list);
        }
        return listList;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        List<List<Integer>> listList = printBinaryTree(t1);
//        List<List<Integer>> listList = levelOrder(t1);
        System.out.println(listList);
    }

}
