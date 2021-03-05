package com.micro.lcl.common.leetcode;

import io.swagger.models.auth.In;

import java.util.Arrays;

/**
 * 二叉树
 *
 * @author Administrator
 * @date 2021/2/414:30
 */
public class TreeNode {
     Integer val;
     TreeNode left;
     TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                " left=" + left +
                ", val=" + val +
                ", right=" + right +
                '}';
    }

    /**
     *
     * @param str  str="3,2,5,null,8,12"
     * @return  int[]  ints={3,2,5,null,8,12}
     */
    public static int[] StrToCharArray(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(null)) {
                ints[i] = Integer.MAX_VALUE;
            }else {
                ints[i] = Integer.parseInt(split[i]);
            }
        }
        System.out.println(Arrays.toString(ints));
        return ints;
    }

    /**
     *
     * @param string    str="3,2,5,null,8,12"
     * @return
     */
    public static TreeNode mkTree(String string) {
        int[] arr = StrToCharArray(string);
        TreeNode[] nodes = new TreeNode[arr.length+1];
        for (int i = 1; i < arr.length+1; i++) {
            if (arr[i - 1] != Integer.MAX_VALUE) {
                nodes[i] = new TreeNode(arr[i - 1]);
            }else {
                nodes[i] = null;
            }
        }
        TreeNode treeNode = null;
        System.out.println(nodes.length/2);
        for (int i = 1; i < nodes.length/2; i++) {
            treeNode = nodes[i];
            if (treeNode == null) {
                continue;
            }
            treeNode.left = nodes[2 * i];
            treeNode.right = nodes[2 * i + 1];
            System.out.println("middle:"+treeNode);

        }
        return nodes[1];
    }
}
