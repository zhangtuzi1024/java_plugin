package com.zhangtuzi.study.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xuzhang on 2018/5/13.
 */
public class ResponseHeaderFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.addHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));//跨域
        response.setHeader("Access-Control-Allow-Methods", "*");//跨域
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,token");//跨域
        response.setHeader("Access-Control-Allow-Credentials", "true");//跨域
        response.addHeader("P3P", "CP=CAO PSA OUR");//IE嵌入不同域名iframe，cookie失效问题
        if (request.getMethod().equals("OPTIONS")) {
            response.setStatus(200);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
