package com.robert.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello world!");
    }
}
