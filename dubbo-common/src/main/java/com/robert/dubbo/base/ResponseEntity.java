package com.robert.dubbo.base;

import lombok.Data;

/**
 * @author changyuwei
 * @date 2019-09-10
 */
@Data
public class ResponseEntity<T> extends BaseBean {

    private static final long serialVersionUID = -359070002999627136L;

    private Integer code;

    private String message;

    private T data;

    public ResponseEntity(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseEntity(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseEntity(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public static ResponseEntity OK() {
        return new ResponseEntity(StatusCode.SUCCESS);
    }

    public static ResponseEntity OK(Object data) {
        ResponseEntity response = new ResponseEntity(StatusCode.SUCCESS);
        response.data = data;
        return response;
    }

    public static ResponseEntity ERROR() {
        return new ResponseEntity(StatusCode.FAIL);
    }

    public static ResponseEntity ERROR(Integer code) {
        return new ResponseEntity(code, null);
    }

    public static ResponseEntity ERROR(Integer code, String message) {
        return new ResponseEntity(code, message);
    }
}
