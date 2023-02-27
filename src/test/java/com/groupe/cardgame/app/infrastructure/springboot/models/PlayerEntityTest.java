package com.groupe.cardgame.app.infrastructure.springboot.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerEntityTest {

    @Test
    void constructor_shouldSetUsername() {
        // Arrange
        String username = "JohnDoe";

        // Act
        PlayerEntity player = new PlayerEntity(username);

        // Assert
        assertEquals(username, player.getUsername());
    }

    @Test
    void constructor_shouldSetDeck() {
        // Arrange
        String username = "JohnDoe";
        DeckEntity deck = new DeckEntity(new PlayerEntity(username));

        // Act
        PlayerEntity player = new PlayerEntity(username, deck);

        // Assert
        assertEquals(deck, player.getDeck());
    }

    @Test
    void updateNumberOfTokens_shouldUpdateNumberOfTokens() {
        // Arrange
        PlayerEntity player = new PlayerEntity("JohnDoe");
        int newNumberOfTokens = 2;

        // Act
        player.updateNumberOfTokens(newNumberOfTokens);

        // Assert
        assertEquals(newNumberOfTokens, player.getNumberOfTokens());
    }


    @Test
    public void noArgsConstructor_shouldCreateObject() {
        PlayerEntity player = new PlayerEntity();
        assertNotNull(player);
    }

    @Test
    public void allArgsConstructor_shouldCreateObject() {
        PlayerEntity player = new PlayerEntity(1L, "John", new DeckEntity());
        assertNotNull(player);
    }


}
