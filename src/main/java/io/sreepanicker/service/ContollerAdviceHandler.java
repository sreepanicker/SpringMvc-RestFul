/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.sreepanicker.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * This is the control aspect for the application.
 * @author sreejithu panicker
 */
@ControllerAdvice
public class ContollerAdviceHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void ArgumentMismatch(){
        System.out.println("BAD request");
    }
    @ResponseStatus(code=HttpStatus.NOT_FOUND,reason = "No Record found")
    @ExceptionHandler(NotFoundException.class)
    public void noRecoundFound(){
        
    }
}
