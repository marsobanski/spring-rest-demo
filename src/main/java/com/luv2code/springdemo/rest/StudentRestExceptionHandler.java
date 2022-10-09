package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// oznacza, że metody z @ExceptionHandler są 'widzialne' w całej aplikacji, a nie tylko w klasie, w której się znajdują
// i są w stanie 'przejąć' wyjątek rzucony w każdej metodzie z @RequestMapping
@ControllerAdvice
public class StudentRestExceptionHandler {

    // adnotacja oznacza, że Spring uznaje metodę za zdolną do ogarnięcia wyjątku, który metoda ma jako argument
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {

        // create a StudentErrorResponse
        StudentErrorResponse response = new StudentErrorResponse();

        //set response fields
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // metoda przyjmująca StudentNotFoundException ogarnia taki wyjątek, a ta metoda ogarnia dowolny inny (klasa Exception)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        StudentErrorResponse response = new StudentErrorResponse();

        //set response fields
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        response.setTimestamp(System.currentTimeMillis());

        // return ResponseEntity
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
