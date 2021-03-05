package com.micro.lcl.common.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *  在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。
 * s 只包含小写字母。
 * @author Administrator
 * @date 2021/2/89:56
 */
public class LeetCode022 {
    public static char OnlyFirst(String str) {
        if (null == str || str.length() == 0) {
            return ' ';
        }
        char[] chars = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>(chars.length);
        for (char aChar : chars) {
            if (map.containsKey(aChar)) {
                map.put(aChar, map.get(aChar) + 1);
            }else {
                map.put(aChar, 1);
            }
        }
        return map.entrySet().stream().filter(f -> f.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(' ');
    }

    public static void main(String[] args) {
        String str = "ababccddeeffffgggr";
        char c = OnlyFirst(str);
        System.out.println(c);
    }
    public static char firstUniqChar(String s) {
        // map的value记录字符出现次数
        // 先遍历字符串s，记录到map中
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch))    map.put(ch, 1);
            else    map.put(ch, map.get(ch) + 1);
        }

        // 再次遍历字符串s，找到记录最靠前的字符
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1)   return s.charAt(i);
        }
        return ' ';
    }
}
