package com.micro.lcl.common.other;

/**
 * 除了双重检查锁之外的线程安全单例模式
 * 枚举
 *这种方式：线程安全、自由串行化、单一实例
 * @author Administrator
 * @date 2021/3/89:59
 */
public enum EnumSington {
    INSTANCE;

    public void test() {
        System.out.println("枚举安装单例！");
    }

    public static void main(String[] args) {
        EnumSington.INSTANCE.test();
    }
}
