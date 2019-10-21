package com.robert.design.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author changyuwei
 * @date 2019-10-10
 */
public class AnimalInvocationHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;

    /**
     * 绑定业务对象并返回一个代理类
     *
     * @param target
     * @return
     */
    public Object bind(Object target) {
        System.out.println("enter method bind 。。。");
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before invoke method " + method.getName() + "=======================");
        System.out.println("proxy: " + proxy.getClass().toString());
        System.out.println(proxy instanceof Proxy);
        System.out.println(proxy instanceof Animal);
        System.out.println(proxy instanceof Dog);
        System.out.println(Arrays.toString(proxy.getClass().getInterfaces()));

        Object result = method.invoke(target, args);
        System.out.println(result);

        System.out.println("after  invoke method " + method.getName() + "=======================");

        return result;
    }
}
