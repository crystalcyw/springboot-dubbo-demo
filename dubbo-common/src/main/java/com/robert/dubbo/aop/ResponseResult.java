package com.robert.dubbo.aop;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 注解-将返回结果封装为{@code ResponseEntity}
 *
 * @author changyuwei
 * @see com.robert.dubbo.base.ResponseEntity
 */
@Retention(RUNTIME)
@Target({TYPE, METHOD})
@Documented
public @interface ResponseResult {

}
