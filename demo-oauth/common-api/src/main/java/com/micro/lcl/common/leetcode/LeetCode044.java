package com.micro.lcl.common.leetcode;

/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * @author Administrator
 * @date 2021/2/2311:44
 */
public class LeetCode044 {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(5);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(8);
        TreeNode t4=new TreeNode(11);
        TreeNode t5=new TreeNode(13);
        TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(2);
        TreeNode t9=new TreeNode(1);
        t1.left=t2;
        t2.right = t3;
        t2.left=t4;
        t3.left=t5;
        t3.right=t6;
        t4.left=t7;
        t4.right=t8;
        t6.right=t9;
        int sum=22;
        boolean hasPathSum = hasPathSum(t1, sum);
        System.out.println("hasPathSum = " + hasPathSum);
    }
}
