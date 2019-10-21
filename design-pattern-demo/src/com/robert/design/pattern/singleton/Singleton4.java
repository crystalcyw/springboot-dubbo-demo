package com.robert.design.pattern.singleton;

/**
 * 4、单例模式-双检锁DCL版
 *
 * @author changyuwei
 * @date 2019-10-23
 */
public class Singleton4 {

  private static Singleton4 instance;

  private Singleton4 () {

  }

  public static Singleton4 getInstance() {
    if (instance == null) {
      synchronized (Singleton4.class) {
        if (instance == null) {
          instance = new Singleton4();
        }
      }
    }
    return instance;
  }
}
