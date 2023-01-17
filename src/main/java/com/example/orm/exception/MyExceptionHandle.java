package com.example.orm.exception;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandle.class);
    @ExceptionHandler(value =Exception.class)
    @ResponseBody
    public JSONObject exceptionHandler(Exception e){

        JSONObject json = new JSONObject();
        json.put("code", 1);
        json.put("errmsg", e.getMessage());
        JSONObject data = new JSONObject();
        var a = e.getStackTrace()[0];
        data.put("msg", e.getMessage());
        data.put("file", a.getFileName());
        data.put("line", a.getLineNumber());
        data.put("method", a.getMethodName());
        json.put("data", data);

        logger.error("服务器错误:" + data.toString());

        return json;
    }
}
