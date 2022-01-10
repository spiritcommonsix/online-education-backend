package com.coc.servicebase.exception;

import com.coc.commonutils.ResultData;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MyServiceException.class)
    @ResponseBody
    public ResultData serviceExceptionHandler(MyServiceException e){
        e.printStackTrace();
        return ResultData.error().message(e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultData otherExceptionHanlder(Exception e){
        e.printStackTrace();
        return ResultData.error().code(50001).message("系统异常");
    }
}
