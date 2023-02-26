package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.response.ApiError;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.CardPackEmptyException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.PlayerNotCreatedException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice

public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     * Handle MethodArgumentNotValidException. Triggered when an object fails @Valid validation.
     *
     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        ApiError apiError = new ApiError(BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }
    /**
     * Handle handleBindException. Triggered when an object fails @Valid validation with @ModelAttribute
     *
     * @param ex      the MethodArgumentNotValidException that is thrown when @Valid validation fails
     * @param headers HttpHeaders
     * @param status  HttpStatus
     * @param request WebRequest
     * @return the ApiError object
     */

    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError(BAD_REQUEST);
        apiError.setMessage("Validation error");
        apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
        apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFoundException(ResourceNotFoundException exc){
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(exc.getSimpleMessage());
        apiError.setDebugMessage(exc.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler(CardPackEmptyException.class)
    public ResponseEntity<Object> handleCardPackEmptyException(CardPackEmptyException exc){
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(exc.getMessage());
        apiError.setDebugMessage(exc.getMessage());
        return buildResponseEntity(apiError);
    }
    @ExceptionHandler({PlayerNotCreatedException.class})
    public ResponseEntity<Object> handlePlayerNotCreatedException(PlayerNotCreatedException exc){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
        apiError.setMessage(exc.getMessage());
        apiError.setDebugMessage(exc.getMessage());
        return buildResponseEntity(apiError);
    }

}