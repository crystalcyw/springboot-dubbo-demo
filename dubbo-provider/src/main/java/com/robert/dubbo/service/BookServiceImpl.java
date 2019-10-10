package com.robert.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.robert.dubbo.entity.Book;
import com.robert.dubbo.exception.BusinessException;
import com.robert.dubbo.mapper.BookMapper;
import com.robert.dubbo.request.BookQuery;
import com.robert.dubbo.request.BookRequest;
import com.robert.dubbo.util.JsonNodeValue;
import com.robert.dubbo.util.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    /**
     * 条件查询
     *
     * @param query
     * @return
     */
    @Override
    public List<Book> list(BookQuery query) {
        if (Objects.isNull(query)) {
            return null;
        }
        QueryWrapper<Book> wrapper = new QueryWrapper<>();

        //名称模糊查询
        if (StringUtils.isNotBlank(query.getName())) {
            wrapper.like("name", query.getName());
        }
        //等于作者
        if (StringUtils.isNotBlank(query.getAuthor())) {
            wrapper.eq("author", query.getAuthor());
        }
        //大于该价格
        if (Objects.nonNull(query.getPrice())) {
            wrapper.gt("price", query.getPrice());
        }
        //创建时间区间
        if (query.getStartTime() != null && query.getEndTime() != null) {
            wrapper.between("gmt_created", query.getStartTime(), query.getEndTime());
        }

        List<Book> books = this.bookMapper.selectList(wrapper);
        return books;
    }

    /**
     * 保存包括新增和修改
     *
     * @param request
     */
    @Override
    public void save(BookRequest request) {
        if (request == null || StringUtils.isBlank(request.getName())
                || request.getPrice() == null || StringUtils.isBlank(request.getAuthor())) {
            throw new BusinessException(10001, "参数为空！");
        }

        Book book = Book.builder()
                .name(request.getName())
                .price(request.getPrice())
                .author(request.getAuthor())
                .ext(JsonUtils.toBean(request.getExt(), JsonNodeValue.class))
                .build();

        if (request.getId() == null) {
            //新增
            this.bookMapper.insert(book);
        } else {
            //修改
            Book db = this.bookMapper.selectById(request.getId());
            if (db == null) {
                throw new BusinessException(10002, "该记录不存在！");
            }

            book.setId(request.getId());
            this.bookMapper.updateById(book);
        }
    }
}
