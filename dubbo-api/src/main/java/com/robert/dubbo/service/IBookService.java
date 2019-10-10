package com.robert.dubbo.service;

import com.robert.dubbo.entity.Book;
import com.robert.dubbo.request.BookQuery;
import com.robert.dubbo.request.BookRequest;

import java.util.List;

/**
 * @author changyuwei
 */
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

    /**
     * 条件查询
     *
     * @param query
     * @return
     */
    List<Book> list(BookQuery query);

    /**
     * 保存包括新增和修改
     *
     * @param request
     */
    void save(BookRequest request);


}
