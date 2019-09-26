package com.robert.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.robert.dubbo.entity.Book;
import com.robert.dubbo.mapper.BookMapper;

import javax.annotation.Resource;

/**
 * @author changyuwei
 * @date 2019-09-10
 */

@Service
public class BookServiceImpl implements IBookService {

    @Resource
    public BookMapper bookMapper;

    @Override
    public String pringBookName(String name) {
        System.out.println(name);
        return name;
    }

    @Override
    public Book getById(Long id) {

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("id为空或非正整数！");
        }
        Book book = this.bookMapper.selectById(id);
        System.out.println(book);

        return book;
    }


}
