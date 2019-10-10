package com.robert.dubbo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.robert.dubbo.base.BaseBean;
import com.robert.dubbo.util.JsonNodeValue;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author changyuwei
 * @date 2019-09-24
 */
@NoArgsConstructor
@Data
@Builder
@TableName("book")
public class Book extends BaseBean {

    private static final long serialVersionUID = 7119785154034073747L;

    @TableId
    private Long id;

    @TableField
    private String name;

    @TableField
    private BigDecimal price;

    @TableField
    private String author;

    @TableField
    private boolean deleted;

    /**
     * 扩展字段
     */
    @TableField
    private JsonNodeValue ext;

    @TableField
    private Date gmtCreated;

    @TableField
    private Date gmtUpdated;
}
