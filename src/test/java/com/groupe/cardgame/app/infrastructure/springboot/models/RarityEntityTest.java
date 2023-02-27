package com.groupe.cardgame.app.infrastructure.springboot.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RarityEntityTest {

    @Test
    public void constructor_shouldSetProperties() {
        // Given
        Long id = 1L;
        String name = "Common";

        // When
        RarityEntity rarity = new RarityEntity(id, name);

        // Then
        assertEquals(id, rarity.getId());
        assertEquals(name, rarity.getName());
    }

    @Test
    public void constructor_withArguments_shouldCreateObject() {
        Long id = 1L;
        String name = "Common";
        RarityEntity rarity = new RarityEntity(id, name);
        assertEquals(id, rarity.getId());
        assertEquals(name, rarity.getName());
    }

    @Test
    public void noArgsConstructor_shouldCreateObject() {
        RarityEntity rarity = new RarityEntity();
        assertNull(rarity.getId());
        assertNull(rarity.getName());
    }
}
