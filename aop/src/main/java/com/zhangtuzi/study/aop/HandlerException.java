package com.zhangtuzi.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.ContentCachingRequestWrapper;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;

/**
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class HandlerException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity ExceptionHandler(Exception ex, ServletRequest cacheRequest) {
        String body = null;
        if (cacheRequest != null && cacheRequest instanceof ContentCachingRequestWrapper) {
            ContentCachingRequestWrapper wrapper = (ContentCachingRequestWrapper) cacheRequest;
            body = StringUtils.toEncodedString(wrapper.getContentAsByteArray(), Charset.forName(wrapper.getCharacterEncoding()));
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String info = String.format("\n请求异常:%s %s %s queryString:%s body:%s", request.getRemoteHost(), request.getMethod(), request.getRequestURI(), request.getQueryString(), body);
        log.error(info, ex);

        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
