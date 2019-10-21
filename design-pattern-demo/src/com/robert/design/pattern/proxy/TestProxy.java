package com.robert.design.pattern.proxy;

/**
 * @author changyuwei
 * @date 2019-10-21
 */
public class TestProxy {

  public static void main(String[] args) {
    Dog dog = new Dog();

    AnimalInvocationHandler handler = new AnimalInvocationHandler();

    Animal proxy = (Animal) handler.bind(dog);

    proxy.eat();

    Cat cat = new Cat();

    proxy = (Animal) handler.bind(cat);

    proxy.eat();
  }
}
