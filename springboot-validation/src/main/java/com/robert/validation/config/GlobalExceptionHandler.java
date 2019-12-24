package com.robert.validation.config;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author changyuwei
 * @date 2019-12-24
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Object handleException(HttpServletRequest request, Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException mane = (MethodArgumentNotValidException) e;
            BindingResult bindingResult = mane.getBindingResult();
            return this.handleErrors(bindingResult);
        } else if (e instanceof BindException) {
            BindException be = (BindException) e;
            BindingResult bindingResult = be.getBindingResult();
            return this.handleErrors(bindingResult);
        }
        return null;
    }

    private String handleErrors(BindingResult bindingResult) {
        List<ObjectError> errors = bindingResult.getAllErrors();
        if (CollectionUtils.isNotEmpty(errors)) {
            ObjectError objectError = errors.get(0);
            return objectError.getDefaultMessage();
        }
        return null;
    }
}
