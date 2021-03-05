package com.micro.lcl.common.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * @author Administrator
 * @date 2021/2/2614:54
 */
public class LeetCode053 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode treeNode) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            if (flag) {
                while (size-- > 0) {
                    TreeNode poll = queue.pollFirst();
                    list.add(poll.val);
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }
                }
            }else {
                while (size-- > 0) {
                    TreeNode poll = queue.pollLast();
                    list.add(poll.val);
                    if (poll.right != null) {
                        queue.push(poll.right);
                    }
                    if (poll.left != null) {
                        queue.push(poll.left);
                    }
                }
            }
            flag = !flag;
            res.add(list);
        }
        return res;
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
        List<List<Integer>> listList = zigzagLevelOrder(t1);
        System.out.println(listList);
    }
}
