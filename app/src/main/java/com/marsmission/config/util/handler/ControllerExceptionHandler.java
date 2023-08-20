package com.marsmission.config.util.handler;


import com.marsmission.config.util.exception.MapEndException;
import com.marsmission.config.util.exception.dto.ExceptionResponse;
import com.marsmission.config.util.exception.dto.ValidationError;
import com.marsmission.config.util.exception.dto.ValidationErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex,
                                                            WebRequest request) {
        ValidationErrorResponse validationError = new ValidationErrorResponse();

        if (ex != null) {
            List<ValidationError> errors = ex.getConstraintViolations()
                    .stream()
                    .map((ConstraintViolation objectError) -> new ValidationError(
                            ((PathImpl)objectError.getPropertyPath()).getLeafNode().getName(),
                            objectError.getInvalidValue(),
                            objectError.getMessage()))
                    .collect(Collectors.toList());

            validationError.setErrors(errors);
        }

        return ResponseEntity.badRequest().body(validationError);
    }

    @ExceptionHandler(MapEndException.class)
    public ResponseEntity<ExceptionResponse> mapEdgeException(MapEndException e) {
        var exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .build();

        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
