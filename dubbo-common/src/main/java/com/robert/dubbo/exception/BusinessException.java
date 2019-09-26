package com.robert.dubbo.exception;

import lombok.Getter;

/**
 * 自定义业务异常
 *
 * @author changyuwei
 * @date 2019-09-25
 */
@Getter
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -8531843955731264961L;

    private Integer code;

    private Object[] params;

    public BusinessException(Integer code) {
        super();
        this.code = code;
    }

    public BusinessException(Integer code, Object[] params) {
        super();
        this.code = code;
        this.params = params;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(Integer code, Object[] params, String message) {
        super(message);
        this.code = code;
        this.params = params;
    }

    public BusinessException(Integer code, Object[] params, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.params = params;
    }
}
