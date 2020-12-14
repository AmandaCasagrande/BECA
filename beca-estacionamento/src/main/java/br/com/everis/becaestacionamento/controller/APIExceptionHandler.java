package br.com.everis.becaestacionamento.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.error.ErrorAttributeOptions.Include;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIExceptionHandler extends AbstractErrorController {
    private static final String ERROR_PATH = "/error";

    @Autowired
    public APIExceptionHandler(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping(path = ERROR_PATH)
    public ResponseEntity<?> handleError(HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        ErrorAttributeOptions options = ErrorAttributeOptions.of(Include.MESSAGE);
        Map<String, Object> errors = getErrorAttributes(request, options);
        errors.remove("exception");
        errors.remove("timestamp");
        errors.remove("path");

        return ResponseEntity.status(status).body(errors);
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}