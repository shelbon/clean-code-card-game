package com.groupe.cardgame.app.application.port.in;

import jakarta.validation.constraints.NotBlank;

import java.io.Serializable;

public record CreatePlayerQuery(@NotBlank String username) implements Serializable {

}