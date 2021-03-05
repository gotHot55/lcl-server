package com.micro.lcl.common.leetcode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 *
 * @author Administrator
 * @date 2021/2/1914:11
 */
public class LeetCode035 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        Class<? extends List> clazz = list.getClass();
        Method method = clazz.getDeclaredMethod("add", Object.class);
        method.invoke(list, "k1");
        System.out.println(list);
        System.out.println("---------------");
        String str = "hello,world";
        String s = rateDescArray(str);
        System.out.println(s);
    }

    public static String rateDescArray(String str) {
        char[] chars = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>(chars.length);
        StringBuilder sb = new StringBuilder(chars.length);
        for (char aChar : chars) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> entryList = map.entrySet().stream().sorted((o1, o2) -> o2.getValue().compareTo(o1.getValue())).collect(Collectors.toList());
        System.out.println(entryList);
        LinkedHashMap<Character, Integer> collect = entryList.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (t1, t2) -> t1, LinkedHashMap::new));
        System.out.println(collect);
        collect.forEach((key,value)->{
            while (value > 0) {
                sb.append(key);
                value -= 1;
            }
        });
        return sb.toString();
    }
}
