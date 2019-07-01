package com.zl.aop;

import com.zl.util.Constants;
import com.zl.util.MessageBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: FruitSales
 * @description: 全局异常统一处理类
 * @author: ZhuLlin
 * @create: 2019-01-17 10:24
 **/

/*
@ControllerAdvice
public class ApplicationControllerExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public MessageBean handlerError(HttpServletRequest req, Exception e) {
        return new MessageBean(false, Constants.ERROR_MSG);
    }

}
*/
