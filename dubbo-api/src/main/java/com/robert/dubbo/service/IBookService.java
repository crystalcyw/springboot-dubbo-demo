package com.robert.dubbo.service;

import com.robert.dubbo.entity.Book;

public interface IBookService {

    String pringBookName(String name);

    Book getById(Long id);
}
