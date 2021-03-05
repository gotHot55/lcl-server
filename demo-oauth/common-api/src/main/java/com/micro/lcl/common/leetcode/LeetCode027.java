package com.micro.lcl.common.leetcode;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 * @author Administrator
 * @date 2021/2/914:22
 */
public class LeetCode027 {
    public static String transWord(String str) {
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = split.length-1; i >= 0; i--) {
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = " hello, i am a student ";
        String word = transWord(str);
        System.out.println(word);

    }
}
