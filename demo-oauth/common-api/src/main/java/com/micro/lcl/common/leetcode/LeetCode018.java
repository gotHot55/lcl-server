package com.micro.lcl.common.leetcode;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，
 * 同一层的节点按照从左到右的顺序打印。
 *
 * @author Administrator
 * @date 2021/2/415:59
 */
public class LeetCode018 {
    public static int[] sequPrint(TreeNode treeNode) {
        if (treeNode == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> listList = new ArrayList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            listList.add(list);
        }
        List<Integer> temp = new ArrayList<>();
        for (List<Integer> list : listList) {
            temp.addAll(list);
        }
        int[] result = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
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
        int[] print = sequPrint(t1);
        System.out.println(Arrays.toString(print));
        
    }
}
