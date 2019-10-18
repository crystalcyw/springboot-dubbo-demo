package com.robert.design.pattern.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author changyuwei
 * @date 2019-10-10
 */
public class AnimalInvocationHandler implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result;

        System.out.println("=======================");

        result = method.invoke(target, args);

        System.out.println("=======================");

        return result;
    }
}
