package com.micro.lcl.common.leetcode;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/1/2910:29
 */
public class Resource implements AutoCloseable {
    public String sayHello() {
        return "hello";
    }
    @Override
    public void close() throws Exception {
        throw new Exception("这是要关闭的资源");
    }
}
