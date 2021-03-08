package com.micro.lcl.common.other;

/**
 * 线程安全的单例模式
 *
 * @author Administrator
 * @date 2021/3/89:41
 */
public class Sington {
    private static volatile Sington instance;

    private Sington() {

    }
    public static Sington getInstance() {
        if (null != instance) {
            return instance;
        }
        synchronized (Sington.class) {
            if (null == instance) {
                instance = new Sington();
            }
        }
        return instance;
    }
}
