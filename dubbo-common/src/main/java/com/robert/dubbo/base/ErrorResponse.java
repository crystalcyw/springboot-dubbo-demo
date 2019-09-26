package com.robert.dubbo.base;

import lombok.Data;

/**
 * @author changyuwei
 * @date 2019-09-25
 */
@Data
public class ErrorResponse extends BaseBean {

    private static final long serialVersionUID = 9055656725529427731L;

    private Integer code;

    private String message;

    private String[] errors;
}
