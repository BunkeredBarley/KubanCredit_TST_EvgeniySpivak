package com.bank.kubancredit_tst_evgeniyspivak.errorHandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchEntityException.class})
    protected ResponseEntity<ErrorDTO> handleConflict(NoSuchEntityException ex, WebRequest request) {
        ErrorDTO errorDTO = new ErrorDTO(501, "Not found in DB. This is a test message");
        return ResponseEntity.status(501).body(errorDTO);
    }

}
