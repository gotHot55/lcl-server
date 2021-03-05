package com.micro.lcl.common.leetcode;

import java.util.*;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。
 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。
 *
 * @author Administrator
 * @date 2021/2/1911:12
 */
public class LeetCode034 {
    public static List<Integer> getAllElements(TreeNode[] nodes) {
        List<Integer> list = new ArrayList<>();
        if (nodes == null || nodes.length == 0) {
            return list;
        }
        for (TreeNode node : nodes) {
            List<Integer> nodelist = getNodes(node);
            list.addAll(nodelist);
        }
        Collections.sort(list);
        return list;
    }

    private static List<Integer> getNodes(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                list.add(poll.val);
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(2);
        TreeNode t12 = new TreeNode(1);
        TreeNode t13 = new TreeNode(4);

        t11.left = t12;
        t11.right = t13;

        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(0);
        TreeNode t23 = new TreeNode(3);
        t21.left = t22;
        t21.right = t23;
        TreeNode[] treeNodes = {t11, t21};
        List<Integer> allElements = getAllElements(treeNodes);
        System.out.println("allElements = " + allElements);

    }
}
