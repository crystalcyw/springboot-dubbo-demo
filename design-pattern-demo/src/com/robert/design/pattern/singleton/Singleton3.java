package com.robert.design.pattern.singleton;

/**
 * 3、单例模式-懒汉式线程安全版
 *
 * @author changyuwei
 * @date 2019-10-23
 */
public class Singleton3 {

  private static Singleton3 instance;

  private Singleton3() {

  }

  public synchronized static Singleton3 getInstance() {
    if (instance == null) {
      instance = new Singleton3();
    }
    return instance;
  }
}
