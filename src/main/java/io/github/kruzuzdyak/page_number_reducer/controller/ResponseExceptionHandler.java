package io.github.kruzuzdyak.page_number_reducer.controller;

import io.github.kruzuzdyak.page_number_reducer.dto.ErrorExtension;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ApiResponse(responseCode = "400", description = "Invalid data in request params", content =
            @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ErrorExtension.class))
    )
    public ResponseEntity<List<ErrorExtension>> handleConstraintViolation(ConstraintViolationException exception) {
        List<ErrorExtension> extensions = exception.getConstraintViolations()
                .stream()
                .map(violation -> new ErrorExtension(violation.getMessage(), "invalid_param"))
                .collect(Collectors.toList());
        return new ResponseEntity<>(extensions, HttpStatus.BAD_REQUEST);
    }
}
