package com.robert.design.pattern.strategy;

/**
 * @author changyuwei
 * @date 2019-10-21
 */
public class TestStrategy {

  public static void main(String[] args) {
    Context context = new Context(new Addition());
    System.out.println(context.function(3, 4));

    context = new Context(new Subtraction());
    System.out.println(context.function(5, 6));
  }
}
