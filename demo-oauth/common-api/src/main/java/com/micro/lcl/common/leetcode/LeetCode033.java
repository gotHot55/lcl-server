package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/1910:58
 */
public class LeetCode033 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t5;
        t3.right = t4;
        List<Integer> list = rightSideView(t1);
        System.out.println("list = " + list);

    }

    private static List<Integer> rightSideView(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode poll = queue.poll();
            for (int i = 0; i < size; i++) {
                list.add(poll.val);
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return list;

    }

}
