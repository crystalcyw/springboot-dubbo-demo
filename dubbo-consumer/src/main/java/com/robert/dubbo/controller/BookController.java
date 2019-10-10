package com.robert.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.robert.dubbo.aop.ResponseResult;
import com.robert.dubbo.base.ResponseEntity;
import com.robert.dubbo.entity.Book;
import com.robert.dubbo.request.BookQuery;
import com.robert.dubbo.request.BookRequest;
import com.robert.dubbo.service.IBookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author changyuwei
 * @date 2019-09-10
 */
//@ResponseResult
@RestController
@RequestMapping("/book")
public class BookController {

    @Reference
    IBookService bookService;

    @GetMapping("/name")
    public ResponseEntity getBookName(@RequestParam(defaultValue = "三国演义") String name) {
        String bookName = this.bookService.printBookName(name);
        return ResponseEntity.OK(bookName);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        Book book = this.bookService.getById(id);
        return ResponseEntity.OK(book);
    }

    @GetMapping("/list")
    public ResponseEntity list(@RequestBody BookQuery query) {
        List<Book> books = this.bookService.list(query);
        return ResponseEntity.OK(books);
    }

    @GetMapping("/save")
    public ResponseEntity save(@RequestBody BookRequest request) {
        this.bookService.save(request);
        return ResponseEntity.OK();
    }
}
