package com.bank.kubancredit_tst_evgeniyspivak.errorHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class ErrorHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NoSuchEntityException.class})
    protected ErrorDTO handleConflict(NoSuchEntityException ex, WebRequest request) {
        return new ErrorDTO(501, "Not found in DB. This is a test message");
    }

}
