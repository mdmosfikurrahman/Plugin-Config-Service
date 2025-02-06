package io.ibos.pcs.common.exception;
import io.ibos.pcs.common.response.ErrorDetails;
import io.ibos.pcs.common.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    private ResponseEntity<RestResponse<List<ErrorDetails>>> buildErrorResponse(HttpStatus status, String message, List<ErrorDetails> errorDetails) {
        RestResponse<List<ErrorDetails>> response = RestResponse.error(status.value(), message, errorDetails);
        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestResponse<List<ErrorDetails>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ErrorDetails> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDetails(error.getField(), error.getDefaultMessage()))
                .toList();
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Validation Error", errors);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<RestResponse<List<ErrorDetails>>> handleCustomValidationExceptions(ValidationException ex) {
        List<ErrorDetails> errors = ex.getErrors().entrySet().stream()
                .map(entry -> new ErrorDetails(entry.getKey(), entry.getValue()))
                .toList();
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Custom Validation Error", errors);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<RestResponse<List<ErrorDetails>>> handleNotFoundException(NotFoundException ex) {
        ErrorDetails errorResponse = new ErrorDetails("Not Found", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Not Found", List.of(errorResponse));
    }

}
