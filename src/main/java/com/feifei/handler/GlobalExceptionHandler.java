package com.feifei.handler;

import com.feifei.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
     	/**
 	* 全局异常处理
 * @param e
 	* @return
 */
         @ExceptionHandler(Exception.class)
         public Result<Object> handleException(Exception e) {
        	e.printStackTrace(); // 打印异常堆栈
        	return Result.fail(e.getMessage(), 500); // 返回统⼀的错误格式
        	}
	}
