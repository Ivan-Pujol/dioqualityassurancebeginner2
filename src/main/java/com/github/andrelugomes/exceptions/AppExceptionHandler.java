package com.github.andrelugomes.exceptions;

import com.github.andrelugomes.cities.resources.DistanceResource;
import jdk.internal.org.jline.utils.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);


    @ExceptionHandler(Exception.class)
    public ResponseEntity HandleANyException(Exception e, WebRequest request){
        log.info("Handling the exception");
        String erro = e.getLocalizedMessage();
        if (erro == null){
            erro = e.toString();
        }
        return new ResponseEntity(erro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
