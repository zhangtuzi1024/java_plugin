package com.zhangtuzi.study.aop;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 切面记录所有业务请求
 */
@Component
@Aspect
@Slf4j
public class ControllerAspect {

    /**
     * 拦截
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Around("execution(!void com..*Controller.*(..))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //region 计算时间
        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        int cost = (int) (end - start);
        //endregion

        //region 记录请求响应、结果、耗时
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String result = String.format(
                "\n请求:%s\n响应:%s,用时:%sms",
                String.format("%s %s %s %s", request.getRemoteHost(), request.getMethod(), request.getRequestURI(), JSONObject.toJSONString(joinPoint.getArgs())),
                object instanceof String ? object : JSONObject.toJSONString(object),
                cost
        );
        if (cost > 1000) {
            log.warn(result);
        } else {
            log.info(result);
        }
        //endregion

        return object;
    }

}
