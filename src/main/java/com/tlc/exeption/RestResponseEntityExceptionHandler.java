package com.tlc.exeption;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

/**
 * Represents custom Exception class for wrap internal exception during application running
 */
@ControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<InvalidLinkException> globalExceptionHandler(InvalidLinkException ex) {
        log.error("Error executing request {}", ex.getMessage());
        return ResponseEntity.status(500).body(ex);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseBody
    public ResponseEntity<InvalidLinkException> notFoundExceptionHandler(InvalidLinkException ex) {
        log.error("Entity not found {}", ex.getMessage());
        return ResponseEntity.status(404).body(ex);
    }
}
