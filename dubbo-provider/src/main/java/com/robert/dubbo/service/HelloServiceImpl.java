package com.robert.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@Service(interfaceClass = IHelloService.class)
@Component
public class HelloServiceImpl implements IHelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("Hello world!" + name);

        return "say Hello to " + name;
    }
}
