package com.micro.lcl.common.leetcode;

/**
 * 双重校验锁实现对象单例（线程安全）
 *
 * @author Administrator
 * @date 2021/2/2514:58
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }
    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
