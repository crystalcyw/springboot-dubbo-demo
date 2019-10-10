package com.robert.dubbo.service;

import com.robert.dubbo.entity.Book;

public interface IBookService {

    /**
     * 打印书名
     *
     * @param name 书名
     * @return
     */
    String printBookName(String name);

    /**
     * 主键查询
     *
     * @param id 主键
     * @return
     */
    Book getById(Long id);
}
