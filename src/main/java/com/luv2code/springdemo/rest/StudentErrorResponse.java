package com.luv2code.springdemo.rest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentErrorResponse {

    private int status;
    private String message;
    private long timestamp;
}
