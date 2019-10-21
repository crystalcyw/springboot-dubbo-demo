package com.robert.design.pattern.singleton;

/**
 * 2、单例模式-懒汉式，单线程版
 *
 * @author changyuwei
 * @date 2019-10-23
 */
public class Singleton2 {

  private static Singleton2 instance;

  private Singleton2() {
  }

  public static Singleton2 getInstance() {
      if (instance == null) {
        instance = new Singleton2();
      }
      return instance;
  }
}
