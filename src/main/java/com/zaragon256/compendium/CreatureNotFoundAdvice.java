package com.zaragon256.compendium;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CreatureNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CreatureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String creatureNotFoundHandler(CreatureNotFoundException ex) {
        return ex.getMessage();
    }
}
