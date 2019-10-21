package com.robert.design.pattern.proxy;

/**
 * @author changyuwei
 * @date 2019-10-21
 */
public class Cat implements Animal {

  @Override
  public void eat() {
    System.out.println("猫🐱吃鱼🐟");
  }
}
