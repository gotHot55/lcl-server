package com.micro.lcl.common.leetcode;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author Administrator
 * @date 2021/2/810:48
 */
public class LeetCode023 {
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode treeLeft = mirrorTree(root.left);
        TreeNode treeRight = mirrorTree(root.right);
        root.right = treeLeft;
        root.left = treeRight;
        return root;
    }

    public static void main(String[] args) {
        String str = "4,2,7,1,3,6,9";
        TreeNode treeNode = TreeNode.mkTree(str);
        System.out.println(treeNode);
        TreeNode mirrorTree = mirrorTree(treeNode);
        System.out.println(mirrorTree);
    }
}
