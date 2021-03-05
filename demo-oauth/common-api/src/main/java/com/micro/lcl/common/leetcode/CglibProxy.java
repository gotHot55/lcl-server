package com.micro.lcl.common.leetcode;

import cn.hutool.aop.proxy.ProxyFactory;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Todo
 *
 * @author Administrator
 * @date 2021/2/2410:58
 */
public class CglibProxy {
    public static void main(String[] args) {
//        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
//        aliSmsService.send("sms");
    }
}

class DebugMethodInterceptor implements MethodInterceptor {
    /**
     * @param o           被代理的对象（需要增强的对象）
     * @param method      被拦截的方法（需要增强的方法）
     * @param args        方法入参
     * @param methodProxy 用于调用原始方法
     */
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用方法之前添加操作: "+method.getName());
        Object res = methodProxy.invokeSuper(o, args);
        System.out.println("调用方法之后添加操作："+method.getName());
        return res;
    }
}

class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        // 创建动态代理增强类
        Enhancer enhancer = new Enhancer();
        // 设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        // 设置被代理类
        enhancer.setSuperclass(clazz);
        // 设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        // 创建代理类
        return enhancer.create();
    }
}
class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
