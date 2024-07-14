package com.davr7.journey_jotter.resources.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
public class ErrorResponse extends StandardError {
    private String message;

    public ErrorResponse(LocalDateTime timestamp, String path, Integer status, String error, String message) {
        super(timestamp, path, status, error);
        this.message = message;
    }
}
