package com.micro.lcl.common.other;

import cn.hutool.core.util.RandomUtil;

import java.util.concurrent.Callable;

/**
 * 简单的Callable任务
 *
 * @author Administrator
 * @date 2021/2/2516:31
 */
public class MyCallable implements Callable<UserModel> {
    private String key;
    private Object xxxService;

    public MyCallable(String key, Object xxxService) {
        this.key = key;
        this.xxxService = xxxService;
    }

    @Override
    public String toString() {
        return "MyCallable{" +
                "key='" + key + '\'' +
                ", xxxService=" + xxxService +
                '}';
    }

    @Override
    public UserModel call() throws Exception {
        UserModel userModel = new UserModel(RandomUtil.randomInt(), "xxx", "123");
        System.out.println(userModel);
        return userModel;
    }
}
