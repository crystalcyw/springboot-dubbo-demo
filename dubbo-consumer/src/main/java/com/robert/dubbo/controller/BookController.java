package com.robert.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.cluster.loadbalance.RoundRobinLoadBalance;
import com.robert.dubbo.aop.ResponseResult;
import com.robert.dubbo.base.ResponseEntity;
import com.robert.dubbo.entity.Book;
import com.robert.dubbo.service.IBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author changyuwei
 * @date 2019-09-10
 */
@ResponseResult
@RestController
@RequestMapping("/book")
public class BookController {

    @Reference(loadbalance = RoundRobinLoadBalance.NAME)
    IBookService bookService;

    @GetMapping("/name")
    public ResponseEntity getBookName(String name) {
        String bookName = this.bookService.pringBookName(name);
        return ResponseEntity.OK(bookName);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) {
        Book book = this.bookService.getById(id);
        return book;
    }
}
