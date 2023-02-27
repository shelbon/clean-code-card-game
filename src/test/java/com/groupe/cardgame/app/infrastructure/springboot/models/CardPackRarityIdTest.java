package com.groupe.cardgame.app.infrastructure.springboot.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class CardPackRarityIdTest {

    @Test
    void shouldCreateValidCardPackRarityId() {
        CardPackRarityId cardPackRarityId = new CardPackRarityId(1L, 2L);
        assertEquals(1L, cardPackRarityId.getRarityId());
        assertEquals(2L, cardPackRarityId.getCardPackId());
    }

    @Test
    void shouldEqualCardPackRarityIdsWithSameValues() {
        CardPackRarityId cardPackRarityId1 = new CardPackRarityId(1L, 2L);
        CardPackRarityId cardPackRarityId2 = new CardPackRarityId(1L, 2L);
        assertEquals(cardPackRarityId1, cardPackRarityId2);
    }


    @Test
    public void testSetters() {
        CardPackRarityId id = new CardPackRarityId(1L, 2L);
        id.setRarityId(3L);
        id.setCardPackId(4L);
        assertEquals(3L, id.getRarityId());
        assertEquals(4L, id.getCardPackId());
    }

    @Test
    public void testHashCode() {
        CardPackRarityId id1 = new CardPackRarityId(1L, 2L);
        CardPackRarityId id2 = new CardPackRarityId(1L, 2L);
        CardPackRarityId id3 = new CardPackRarityId(3L, 4L);
        assertEquals(id1.hashCode(), id2.hashCode());
        assertNotEquals(id1.hashCode(), id3.hashCode());
    }
}
