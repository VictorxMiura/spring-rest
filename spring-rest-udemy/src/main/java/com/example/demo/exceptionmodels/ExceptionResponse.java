package com.example.demo.exceptionmodels;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@Getter
@Setter
public class ExceptionResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Date timestamp;
    private String Message;
    private String Details;


    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.Message = message;
        this.Details = details;
    }
}
