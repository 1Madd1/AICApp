package org.aiesec.aicapp.error;

import io.swagger.v3.oas.annotations.Hidden;
import org.aiesec.aicapp.error.exception.AICAppException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Hidden
public class ErrorHandlingController {

    @ExceptionHandler(AICAppException.class)
    public ResponseEntity<ExceptionResponse> generalEventPlannerException(AICAppException ex) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(ex.getMessage());
        response.setCode(ex.getCode());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(Integer.parseInt(ex.getCode())));
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ExceptionResponse> generalException(Exception ex) {
//        ExceptionResponse response = new ExceptionResponse();
//        response.setMessage(ex.getMessage());
//        return new ResponseEntity<>(response, HttpStatus.);
//    } Create other necessary exception handlers

}
