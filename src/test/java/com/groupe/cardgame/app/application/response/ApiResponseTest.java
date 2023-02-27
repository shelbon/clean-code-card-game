package com.groupe.cardgame.app.application.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiResponseTest {

    @Test
    void shouldCreateValidApiResponseWithThreeArguments() {
        HttpStatus status = HttpStatus.OK;
        LocalDateTime timestamp = LocalDateTime.now();
        String message = "Success";

        ApiResponse response = new ApiResponse(status, timestamp, message);

        assertEquals(status, response.getStatus());
        assertEquals(timestamp, response.getTimestamp());
        assertEquals(message, response.getMessage());
    }

    @Test
    void shouldCreateValidApiResponseWithTwoArguments() {
        HttpStatus status = HttpStatus.OK;
        String message = "Success";

        ApiResponse response = new ApiResponse(status, message);

        assertEquals(status, response.getStatus());
        assertEquals(message, response.getMessage());
    }

    @Test
    void shouldCreateValidApiResponseWithOneArgument() {
        HttpStatus status = HttpStatus.OK;

        ApiResponse response = new ApiResponse(status);

        assertEquals(status, response.getStatus());
        assertEquals(LocalDateTime.now().getDayOfMonth(), response.getTimestamp().getDayOfMonth());
    }

    @Test
    void shouldCreateValidApiResponseWithBuilder() {
        HttpStatus status = HttpStatus.OK;
        String message = "Success";

        ApiResponse response = ApiResponse.builder()
                .status(status)
                .message(message)
                .build();

        assertEquals(status, response.getStatus());
        assertEquals(message, response.getMessage());
        assertEquals(LocalDateTime.now().getDayOfMonth(), response.getTimestamp().getDayOfMonth());
    }

    @Test
    void shouldCreateValidApiResponse() {
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, LocalDateTime.now(), "message");
        apiResponse.setStatus(HttpStatus.BAD_REQUEST);
        apiResponse.setTimestamp(LocalDateTime.now().minusDays(1));
        apiResponse.setMessage("new message");
        assertEquals(HttpStatus.BAD_REQUEST, apiResponse.getStatus());
        assertEquals("new message", apiResponse.getMessage());
        assertEquals(apiResponse.getTimestamp().toLocalDate(), LocalDateTime.now().minusDays(1).toLocalDate());
    }

}
