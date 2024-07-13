package com.davr7.journey_jotter.resources.exceptions;

import com.davr7.journey_jotter.services.exceptions.ParticipantNotFoundException;
import com.davr7.journey_jotter.services.exceptions.TripNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = { TripNotFoundException.class, ParticipantNotFoundException.class })
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(Exception ex, HttpServletRequest req) {
        String error = "Not Found";
        return new ErrorResponse(Instant.now(), req.getRequestURI(), HttpStatus.NOT_FOUND.value(), error, ex.getMessage());
    }
}
