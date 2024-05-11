package com.rodolfobrandao.aulajavacollectionsproject.controllers.advice;

import com.rodolfobrandao.aulajavacollectionsproject.models.json.response.ExceptionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleException(Exception ex) {
        return ResponseEntity.internalServerError().body(new ExceptionResponse(ex));
    }

}
