package com.robert.dubbo.request;

import com.robert.dubbo.base.BaseBean;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author changyuwei
 * @date 2019-10-10
 */
@Data
public class BookQuery extends BaseBean {
    private static final long serialVersionUID = -5081217882324770269L;

    private String name;

    private BigDecimal price;

    private String author;

    private Date startTime;

    private Date endTime;
}
