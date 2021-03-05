package com.micro.lcl.common.leetcode;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 计算从根到叶子节点生成的所有数字之和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author Administrator
 * @date 2021/2/2311:26
 */
public class LeetCode043 {
    public static int sum = 0;
    public static int sumNumbers(TreeNode treeNode) {
        if (treeNode == null) {
            return sum;
        }
        currentSum(treeNode, 0);
        return sum;
    }

    private static void currentSum(TreeNode treeNode, int father) {
        if (treeNode == null) {
            return;
        }
        int current = father * 10 + treeNode.val;
        if (treeNode.left == null && treeNode.right == null) {
            sum += current;
            return;
        }
        currentSum(treeNode.left, current);
        currentSum(treeNode.right, current);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
//        TreeNode t4 = new TreeNode(5);
//        TreeNode t5 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
//        t2.left = t4;
//        t2.right = t5;
        int sumValue = sumNumbers(t1);
        System.out.println("sumValue = " + sumValue);
    }
}
