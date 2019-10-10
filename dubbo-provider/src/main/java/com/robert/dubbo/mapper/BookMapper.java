package com.robert.dubbo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.robert.dubbo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author changyuwei
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {

}
