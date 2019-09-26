package com.robert.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.robert.dubbo.base.ResponseEntity;
import com.robert.dubbo.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference
    HelloService helloService;

    @GetMapping
    public ResponseEntity sayHello() {
        this.helloService.sayHello();
        return ResponseEntity.OK();
    }
}
