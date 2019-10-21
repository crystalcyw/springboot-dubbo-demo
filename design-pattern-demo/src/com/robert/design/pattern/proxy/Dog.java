package com.robert.design.pattern.proxy;

/**
 * @author changyuwei
 * @date 2019-10-10
 */
public class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("狗吃骨头🦴");
    }
}
