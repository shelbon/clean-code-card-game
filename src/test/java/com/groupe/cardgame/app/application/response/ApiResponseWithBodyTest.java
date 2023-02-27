package com.groupe.cardgame.app.application.response;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ApiResponseWithBodyTest {

    @Test
    void shouldCreateValidApiResponseWithBody() {
        ApiResponseWithBody<String> apiResponseWithBody = new ApiResponseWithBody<>(HttpStatus.OK, LocalDateTime.now(), "message");
        assertEquals(HttpStatus.OK, apiResponseWithBody.getStatus());
        assertEquals("message", apiResponseWithBody.getMessage());
    }

    @Test
    void shouldCreateValidApiResponseWithBodyWithTwoArguments() {
        ApiResponseWithBody<String> apiResponseWithBody = new ApiResponseWithBody<>(HttpStatus.OK, "message", "payload");
        assertEquals(HttpStatus.OK, apiResponseWithBody.getStatus());
        assertEquals("message", apiResponseWithBody.getMessage());
        assertEquals("payload", apiResponseWithBody.getPayload());
    }


    @Test
    void shouldCreateValidApiResponseWithBodyWithOneArgument() {
        ApiResponseWithBody<String> apiResponseWithBody = new ApiResponseWithBody<>(HttpStatus.OK, "payload");
        assertEquals(HttpStatus.OK, apiResponseWithBody.getStatus());
        assertEquals(null, apiResponseWithBody.getPayload());
    }

    @Test
    void shouldVerifyTheConstructWithPayloadAndStatus() {
        ApiResponseWithBody<Integer> apiResponseWithBody = new ApiResponseWithBody<>(HttpStatus.OK, 0 );
        assertEquals(HttpStatus.OK, apiResponseWithBody.getStatus());
        assertEquals(0, apiResponseWithBody.getPayload());
    }

    @Test
    void shouldSetPayload() {
        ApiResponseWithBody<String> apiResponseWithBody = new ApiResponseWithBody<>(HttpStatus.OK, LocalDateTime.now(), "message");
        apiResponseWithBody.setPayload("payload");
        assertEquals("payload", apiResponseWithBody.getPayload());
    }

}
