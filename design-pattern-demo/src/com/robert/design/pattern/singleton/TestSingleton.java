package com.robert.design.pattern.singleton;

/**
 * @author changyuwei
 * @date 2019-10-23
 */
public class TestSingleton {

  public static void main(String[] args) {
    Singleton1 instance1 = Singleton1.getInstance();
    Singleton1 instance2 = Singleton1.getInstance();
    System.out.println(instance1 == instance2);

    Singleton2 instance3 = Singleton2.getInstance();
    Singleton2 instance4 = Singleton2.getInstance();
    System.out.println(instance3 == instance4);

    Singleton3 instance5 = Singleton3.getInstance();
    Singleton3 instance6 = Singleton3.getInstance();
    System.out.println(instance5 == instance6);

    Singleton4 instance7 = Singleton4.getInstance();
    Singleton4 instance8 = Singleton4.getInstance();
    System.out.println(instance7 == instance8);

    Singleton5 instance9 = Singleton5.getInstance();
    Singleton5 instance10 = Singleton5.getInstance();
    System.out.println(instance9 == instance10);

    Singleton6 instance11 = Singleton6.getInstance();
    Singleton6 instance12 = Singleton6.getInstance();
    System.out.println(instance11 == instance12);

    Singleton7 instance13 = Singleton7.INSTANCE;
    Singleton7 instance14 = Singleton7.INSTANCE;
    System.out.println(instance13 == instance14);
  }
}
