package com.micro.lcl.common.leetcode;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/2410:38
 */
class test {
    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}
class DebugInvocationHandler implements InvocationHandler {
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("调用方法之前添加操作: "+method.getName());
        Object res = method.invoke(target, objects);
        System.out.println("调用方法之后添加操作："+method.getName());
        return res;
    }
}

class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}

interface SmsService {
    String send(String msg);
}

class SmsServiceImpl implements SmsService {

    @Override
    public String send(String msg) {
        System.out.println("send message:" + msg);
        return msg;
    }
}


