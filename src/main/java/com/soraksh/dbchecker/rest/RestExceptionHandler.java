package com.soraksh.dbchecker.rest;

import com.soraksh.dbchecker.rest.exception.EntityNotFoundException;
import com.soraksh.dbchecker.rest.exception.ExceptionInfo;
import com.soraksh.dbchecker.rest.exception.MetadataServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.PersistenceException;

@ControllerAdvice
public class RestExceptionHandler {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ExceptionInfo> handleEntityNotFoundException(EntityNotFoundException e) {
        ExceptionInfo info = new ExceptionInfo("EntityNotFoundException", e.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(MetadataServiceException.class)
    ResponseEntity<ExceptionInfo> handleMetadataServiceException(MetadataServiceException e) {
        ExceptionInfo info = new ExceptionInfo(e.getName(), e.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(PersistenceException.class)
    ResponseEntity<ExceptionInfo> handlePersistenceException(PersistenceException e) {
        ExceptionInfo info = new ExceptionInfo(e.getClass().getSimpleName(), e.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }
}
