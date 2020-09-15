package com.zhangtuzi.study.config;

import com.zhangtuzi.study.filter.ResponseHeaderFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 * Created by xuzhang on 2018/5/13.
 */
@Configuration
public class FilterConfig {


    @Bean
    public FilterRegistrationBean headFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ResponseHeaderFilter());
        registration.addUrlPatterns("/*");
        registration.setName(ResponseHeaderFilter.class.getSimpleName());
        registration.setOrder(1);
        return registration;
    }

}
