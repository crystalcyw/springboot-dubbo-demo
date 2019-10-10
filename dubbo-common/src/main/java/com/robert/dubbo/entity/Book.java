package com.robert.dubbo.entity;

import com.robert.dubbo.base.BaseBean;
import com.robert.dubbo.util.JsonNodeValue;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author changyuwei
 * @date 2019-09-24
 */
@Data
public class Book extends BaseBean {

    private static final long serialVersionUID = 7119785154034073747L;

    private Long id;

    private String name;

    private BigDecimal price;

    private String author;

    private boolean deleted;

    /**
     * 扩展字段
     */
    private JsonNodeValue ext;

    private Date gmtCreated;

    private Date gmtUpdated;
}
