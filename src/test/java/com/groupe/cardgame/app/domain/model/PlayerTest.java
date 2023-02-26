package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @Test
    void testGetUsername() {
        Player player = new Player();
        player.setUsername("Alice");
        assertEquals("Alice", player.getUsername());
    }

    @Test
    void testSetUsername() {
        Player player = new Player();
        player.setUsername("Bob");
        assertEquals("Bob", player.getUsername());
    }

    @Test
    void testGetNumberOfTokens() {
        Player player = new Player();
        player.setNumberOfTokens(10);
        assertEquals(10, player.getNumberOfTokens());
    }

    @Test
    void testSetNumberOfTokens() {
        Player player = new Player();
        player.setNumberOfTokens(5);
        assertEquals(5, player.getNumberOfTokens());
    }
}
