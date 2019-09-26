package com.robert.dubbo.base;

import lombok.Getter;

/**
 * @author changyuwei
 */

@Getter
public enum StatusCode {

    /**
     * 成功
     */
    SUCCESS(200, "success"),

    /**
     * 失败
     */
    FAIL(-1, "fail");

    private Integer code;

    private String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
