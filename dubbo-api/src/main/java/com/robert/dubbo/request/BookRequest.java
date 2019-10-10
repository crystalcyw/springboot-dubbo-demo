package com.robert.dubbo.request;

import com.robert.dubbo.base.BaseBean;
import com.robert.dubbo.util.BeanMap;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author changyuwei
 * @date 2019-10-10
 */
@Data
public class BookRequest extends BaseBean {
    private static final long serialVersionUID = 6793255498509277986L;

    private Long id;

    private String name;

    private BigDecimal price;

    private String author;

    private boolean deleted;

    /**
     * 扩展字段
     */
    private BeanMap ext;

    private Date gmtCreated;

    private Date gmtUpdated;
}
