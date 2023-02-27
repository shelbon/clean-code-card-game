package com.groupe.cardgame.app.application.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiValidationErrorTest {

    @Test
    void shouldCreateValidValidationError() {
        ApiValidationError validationError = new ApiValidationError("objectName", "fieldName", "rejectedValue", "errorMessage");
        assertEquals("objectName", validationError.getObject());
        assertEquals("fieldName", validationError.getField());
        assertEquals("rejectedValue", validationError.getRejectedValue());
        assertEquals("errorMessage", validationError.getMessage());
    }

    @Test
    void shouldCreateValidValidationErrorWithTwoArguments() {
        ApiValidationError validationError = new ApiValidationError("objectName", "errorMessage");
        assertEquals("objectName", validationError.getObject());
        assertEquals("errorMessage", validationError.getMessage());
    }

}
