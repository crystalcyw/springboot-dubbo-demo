package com.robert.design.pattern.strategy;

/**
 * @author changyuwei
 * @date 2019-10-21
 */
public class Context {

  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public int function(int a, int b) {
    return this.strategy.function(a, b);
  }
}
