package com.marsmission.config.util.exception.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {

    private List<ValidationError> errors;
}
