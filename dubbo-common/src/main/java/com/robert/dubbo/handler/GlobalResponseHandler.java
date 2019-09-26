package com.robert.dubbo.handler;

import com.robert.dubbo.aop.ResponseResult;
import com.robert.dubbo.base.ErrorResponse;
import com.robert.dubbo.base.ResponseEntity;
import com.robert.dubbo.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一的响应封装及异常处理
 *
 * @author changyuwei
 * @date 2019-09-25
 */
@Slf4j
@RestControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice {

    private static final String RESPONSE_RESULT_ANNOTATION = "RESPONSE_RESULT_ANNOTATION";

    /**
     * Whether this component supports the given controller method return type
     * and the selected {@code HttpMessageConverter} type.
     *
     * @param returnType    the return type
     * @param converterType the selected converter type
     * @return {@code true} if {@link #beforeBodyWrite} should be invoked;
     * {@code false} otherwise
     */
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        //判断 request 是否有包装标记
        ResponseResult result = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANNOTATION);
        return result != null;
    }

    /**
     * Invoked after an {@code HttpMessageConverter} is selected and just before
     * its write method is invoked.
     *
     * @param body                  the body to be written
     * @param returnType            the return type of the controller method
     * @param selectedContentType   the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request               the current request
     * @param response              the current response
     * @return the body that was passed in or a modified (possibly new) instance
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        log.info("进入返回体重写，处理中。。。");
        // 返回异常封装
        if (body instanceof ErrorResponse) {
            ErrorResponse errorResponse = (ErrorResponse) body;
            return ResponseEntity.ERROR(errorResponse.getCode(), errorResponse.getMessage());
        }
        //返回成功封装
        return ResponseEntity.OK(body);
    }

    // ==================== Exception Handler ==================== //

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity businessExceptionHandler(BusinessException exception) {
        log.error("[ BusinessException ] , message:{}" + exception.getMessage());
        return ResponseEntity.ERROR(exception.getCode(), exception.getMessage());
    }

}
