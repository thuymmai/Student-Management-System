package com.project.sms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice //this annotation allows handling exceptions across the whole application in one global handling component
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /* Handle two exceptions: global and CSRF token*/
    @ExceptionHandler(CsrfException.class)
    public String csrfExceptionHandler(CsrfException ex, RedirectAttributes redirectAttributes) {

        //generic warning message
        log.warn("CSRF validation failed", ex.getMessage());

        //when there is a redirect, I have to send a message to inform users why there is a redirection
        redirectAttributes.addFlashAttribute("message", "Session expired. Please log in again.");
        return "redirect:/login";
    }

    @ExceptionHandler(Exception.class)

    //need to specify a response status, otherwise, the exception handler will assume it is a 200 error internally
    //just need to handle this once, which will handle everything
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String genericExceptionHandler(Exception ex) {
        log.error("Something went wrong", ex);

        //will create a 500 error page later
        return "500";
    }
}
