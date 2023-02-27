package com.groupe.cardgame.app.application.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ApiResponseWithBody<T> extends ApiResponse {
    private T payload;

    public ApiResponseWithBody(HttpStatus status, LocalDateTime timestamp, String message) {
        super(status, timestamp, message);
    }

    public ApiResponseWithBody(HttpStatus status, String message, T payload) {
        super(status, message);
        this.payload = payload;
    }

    public ApiResponseWithBody(HttpStatus status, T payload) {
        super(status);
        this.payload = payload;
    }

    public ApiResponseWithBody(HttpStatus status, String message) {
        super(status, message);
    }
}