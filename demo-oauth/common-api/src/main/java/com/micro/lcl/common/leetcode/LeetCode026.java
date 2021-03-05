package com.micro.lcl.common.leetcode;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
 * 如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * @author Administrator
 * @date 2021/2/914:13
 */
public class LeetCode026 {
    public static int lastWordLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        String[] split = str.split(" ");
        return split[split.length - 1].length();
//        char[] chars = str.toCharArray();
//        int count = 0;
//        for (int i = chars.length-1; i > 0; i--) {
//            if (chars[i] != ' ') {
//                count++;
//            }else {
//                return count;
//            }
//        }
//        return count;
    }

    public static void main(String[] args) {
        String str = "hellwwwo world!";
        int length = lastWordLength(str);
        System.out.println(length);
    }
}
