package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.DTO;

/**
 * A Projection for the {@link com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity} entity
 */
public record SimplePlayerInfo(Long id, String username) {
}