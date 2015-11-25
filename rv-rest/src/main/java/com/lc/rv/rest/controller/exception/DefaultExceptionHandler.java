package com.lc.rv.rest.controller.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

/**
 * @author Alexey.Koyro
 */
@ControllerAdvice
public class DefaultExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    private static final String DEFAULT_ERROR_MESSAGE = "Unknown error occured";

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ErrorDetails handleException(Exception e) {
        LOGGER.error("Error occured", e);

        ErrorDetails errorDetails = new ErrorDetails();

        String exceptionMessage = e.getMessage() != null ? e.getMessage() : DEFAULT_ERROR_MESSAGE;
        errorDetails.setErrorDetail(exceptionMessage);

        return errorDetails;
    }


    public static class ErrorDetails implements Serializable {
        private String errorDetail;

        public String getErrorDetail() {
            return errorDetail;
        }

        public void setErrorDetail(String errorDetail) {
            this.errorDetail = errorDetail;
        }
    }
}
