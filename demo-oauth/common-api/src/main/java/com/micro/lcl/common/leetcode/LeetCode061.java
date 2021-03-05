package com.micro.lcl.common.leetcode;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点
 *
 * @author Administrator
 * @date 2021/3/311:21
 */
public class LeetCode061 {
    public static int minDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }
        int minValue = Integer.MAX_VALUE;
        if (treeNode.left != null) {
            minValue = Math.min(minDepth(treeNode.left), minValue);
        }
        if (treeNode.right != null) {
            minValue = Math.min(minDepth(treeNode.right), minValue);
        }
        return minValue + 1;
    }

    public static int minDepth2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftDepth = 0;
        int rightDepth = 0;
        if (treeNode != null) {
            leftDepth= minDepth2(treeNode.left) + 1;
            rightDepth = minDepth2(treeNode.right) + 1;
        }
        return leftDepth > rightDepth ? rightDepth : leftDepth;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4.left;
        t3.right = t5;
        int depth = minDepth2(t1);
        System.out.println(depth);
    }
}
