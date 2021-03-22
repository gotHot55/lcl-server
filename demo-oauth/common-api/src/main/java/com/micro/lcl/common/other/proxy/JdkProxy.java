package com.micro.lcl.common.other.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/3/1714:37
 */
interface SendSms {
    String send(String message);
}

class SendSmsService implements SendSms{

    @Override
    public String send(String message) {
        System.out.println("message:"+message);
        return message;
    }
}

class JdkInvocation implements InvocationHandler {
    private final Object target;

    JdkInvocation(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("method name:" + method.getName());
        method.invoke(target, objects);
        System.out.println("after method:" + method.getName());
        return null;
    }
}

class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new JdkInvocation(target));
    }
}

class Test {
    public static void main(String[] args) {
        SendSms proxy = (SendSms) JdkProxyFactory.getProxy(new SendSmsService());
        proxy.send("java");
    }
}
