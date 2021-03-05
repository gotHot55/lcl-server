package com.micro.lcl.common.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/2211:33
 */
public class LeetCode039 {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        TreeNode t9=new TreeNode(9);
        TreeNode t10=new TreeNode(10);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.right=t6;

        t4.left=t7;
        t4.right = t9;
        t6.left = t10;
        t6.right=t8;
        int leaveSum = deepestLeaveSum(t1);
        System.out.println("leaveSum = " + leaveSum);

    }

    private static int deepestLeaveSum(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(treeNode);
        int result = 0;
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
            System.out.println("mid:"+mid);
            result = mid;
        }
        return result;
    }
}
