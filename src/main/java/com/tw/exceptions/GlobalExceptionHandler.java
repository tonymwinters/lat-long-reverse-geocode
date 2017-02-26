package com.tw.exceptions;

import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tonywinters on 2/26/17.
 */
@ControllerAdvice
@Component
public class GlobalExceptionHandler {

    Gson gson = new Gson();

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        ExceptionEntity exceptionEntity = new ExceptionEntity("MISSING PARAMETER", ex.getParameterName(), ex.getMessage(), HttpStatus.BAD_REQUEST);
        return gson.toJson(exceptionEntity);
    }
}