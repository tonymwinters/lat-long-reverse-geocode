package com.tw.exceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by tonywinters on 2/26/17.
 */
public class ExceptionEntity {

    private HttpStatus status;
    private String type;
    private String value;
    private String message;

    public ExceptionEntity(String type, String value, String message, HttpStatus status) {
        this.type = type;
        this.value = value;
        this.message = message;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
