package com.pmdevelop.propertymanagement.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component  // AOP 切面类需要被 Spring 管理
public class LoggingAspect {

    @Autowired
    private ObjectMapper objectMapper;  // 用于将对象转换为 JSON 字符串

    @AfterReturning(value = "execution(* com.pmdevelop.propertymanagement.service.*.*(..))", returning = "result")
    public void logReturnedObject(Object result) {
        try {
            String json = objectMapper.writeValueAsString(result);  // 将对象转换为 JSON 字符串
            System.out.println("Returned Object as JSON: " + json);  // 打印 JSON 格式
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
