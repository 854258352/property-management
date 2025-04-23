package com.pmdevelop.propertymanagement.exception;

import com.pmdevelop.propertymanagement.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception e) {
        return new ResponseEntity<>(ApiResponse.error(500, "系统错误: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}