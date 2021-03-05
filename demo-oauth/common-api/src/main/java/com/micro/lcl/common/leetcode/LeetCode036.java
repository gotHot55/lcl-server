package com.micro.lcl.common.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 *
 * @author Administrator
 * @date 2021/2/2014:06
 */
public class LeetCode036 {
    public static int leftValue(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                result = poll.val;
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (poll.left != null) {
                    queue.add(poll.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        int i = leftValue(t1);
        System.out.println(i);
    }
}
