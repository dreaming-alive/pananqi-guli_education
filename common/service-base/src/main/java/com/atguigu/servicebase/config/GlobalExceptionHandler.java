package com.atguigu.servicebase.config;

import com.atguigu.commonutils.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 王永超
 * @description
 * @date 2020/6/21
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler
    @ResponseBody
    public R error(Exception e){
        e.printStackTrace();
        return R.error().message(e.getMessage());
    }
    
    @ExceptionHandler(value = {GuliException.class})
    @ResponseBody
    public R error(GuliException e){
        e.printStackTrace();
        return R.error().message(e.getMessage()).code(e.getCode());
    }
}
