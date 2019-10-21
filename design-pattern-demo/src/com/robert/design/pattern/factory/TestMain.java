package com.robert.design.pattern.factory;

import java.io.File;
import java.util.Arrays;

/**
 * @author changyuwei
 * @date 2019-10-18
 */
public class TestMain {

  public static void main(String[] args) {
    System.out.println(5 * 1024 * 1024);
    System.out.println(5 << 20);
    System.out.println(500 * 1024 * 1024);
    System.out.println(125 << 22);
    System.out.println(500 * 1024 * 1024 == 125 << 22);
    System.out.println(Arrays.toString(File.listRoots()));
    System.out.println(File.pathSeparator.getClass());
    try {
      System.out.println(Class.forName("char"));
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println(File.separator);
    System.out.println(File.separatorChar);

    System.out.println("abcd".substring(2));
  }
}
