package com.robert.design.pattern.singleton;

/**
 * 5、单例模式- DCL + volatile
 *
 * @author changyuwei
 * @date 2019-10-23
 */
public class Singleton5 {

  private static volatile Singleton5 instance;

  private Singleton5 () {

  }

  public static Singleton5 getInstance() {
    if (instance == null) {
      synchronized (Singleton5.class) {
        if (instance == null) {
          instance = new Singleton5();
        }
      }
    }
    return instance;
  }
}
