package com.davr7.journey_jotter.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class StandardError {
    protected LocalDateTime timestamp;
    protected String path;
    protected Integer status;
    protected String error;
}
