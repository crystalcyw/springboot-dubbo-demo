package com.robert.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.robert.dubbo.entity.Book;
import com.robert.dubbo.mapper.BookMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author changyuwei
 * @date 2019-09-10
 */

@Service(interfaceClass = IBookService.class)
@Component
public class BookServiceImpl implements IBookService {

    @Resource
    public BookMapper bookMapper;

    @Override
    public String printBookName(String name) {
        System.out.println(name);
        return "book name " + name;
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
