package com.groupe.cardgame.app.application.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;

public record CardPackFillRandomQuery(@Min(1L) long cardPackId, @Min(1) int numberOfCard) implements Serializable {
}