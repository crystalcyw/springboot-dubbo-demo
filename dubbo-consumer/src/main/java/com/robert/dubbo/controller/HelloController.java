package com.robert.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.robert.dubbo.base.ResponseEntity;
import com.robert.dubbo.service.IHelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyuwei
 * @date 2019-09-11
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Reference
    IHelloService helloService;

    @GetMapping("/sayHello")
    public ResponseEntity sayHello(@RequestParam(defaultValue = "倾城") String name) {
        String hello = this.helloService.sayHello(name);
        return ResponseEntity.OK(hello);
    }
}
