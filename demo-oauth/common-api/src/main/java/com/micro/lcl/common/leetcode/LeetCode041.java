package com.micro.lcl.common.leetcode;


import java.util.*;

/**
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * @author Administrator
 * @date 2021/2/2214:15
 */
public class LeetCode041 {
    public static int[] rowMaxValue(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
//                maxValue = maxValue > poll.val ? maxValue : poll.val;
                maxValue = Math.max(maxValue, poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            list.add(maxValue);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(9);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        int[] result = rowMaxValue(t1);
        System.out.println("integerList = " + Arrays.toString(result));

    }
}
