package com.robert.design.pattern.singleton;

/**
 * 1、单例模式一饿汉式
 *
 * @author changyuwei
 * @date 2019-10-23
 */
public class Singleton1 {

  private static Singleton1 singleton1 = new Singleton1();

  private Singleton1() {

  }

  public static Singleton1 getInstance() {
    return singleton1;
  }
}
