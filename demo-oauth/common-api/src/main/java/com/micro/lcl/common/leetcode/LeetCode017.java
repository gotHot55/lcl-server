package com.micro.lcl.common.leetcode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * @author Administrator
 * @date 2021/2/414:40
 */
public class LeetCode017 {
    public static int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (treeNode != null) {
            leftHeight = height(treeNode.left)+1;
            rightHeight = height(treeNode.right) + 1;
        }
        return leftHeight > rightHeight ? leftHeight : rightHeight;
//        return Math.max(height(treeNode.left), height(treeNode.right)) + 1;
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
    t4.right = t5;
//        System.out.println(t1);
        int height = height(t1);
        System.out.println(height);

    }
}
