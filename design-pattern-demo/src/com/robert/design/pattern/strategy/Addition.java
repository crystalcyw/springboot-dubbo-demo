package com.robert.design.pattern.strategy;

/**
 * @author changyuwei
 * @date 2019-10-21
 */
public class Addition implements Strategy {

  @Override
  public int function(int a, int b) {
    return a + b;
  }
}
