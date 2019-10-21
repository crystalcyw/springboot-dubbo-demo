package com.robert.design.pattern.singleton;

/**
 * 6、单例模式-静态内部类版
 *
 * @author changyuwei
 * @date 2019-10-23
 */
public class Singleton6 {

  private Singleton6 () {

  }

  private static class Singleton6Holder {
    private static Singleton6 instance = new Singleton6();
  }

  public static Singleton6 getInstance() {
    return Singleton6Holder.instance;
  }
}
