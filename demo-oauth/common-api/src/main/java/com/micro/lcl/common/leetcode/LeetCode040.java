package com.micro.lcl.common.leetcode;

import java.util.*;

/**
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 * @author Administrator
 * @date 2021/2/2211:50
 */
public class LeetCode040 {
    public static int maxLevelValue(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        Map<Integer, Integer> map = new HashMap<>();
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int mid = 0;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                mid += poll.val;
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
            map.put(level, mid);
            level++;
        }
        System.out.println(map.toString());
        Integer integer = map.values().stream().max(Comparator.naturalOrder()).get();
        System.out.println("最大值：" + integer);
        return map.entrySet().stream().filter(p -> p.getValue().equals(integer)).map(Map.Entry::getKey).findFirst().orElse(0);
    }
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(0);
        TreeNode t4 = new TreeNode(7);
        TreeNode t5 = new TreeNode(-8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        int maxLevelSum = maxLevelValue(t1);
        System.out.println("maxLevelSum = " + maxLevelSum);
    }
}
