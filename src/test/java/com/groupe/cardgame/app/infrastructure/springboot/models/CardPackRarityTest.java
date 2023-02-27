package com.groupe.cardgame.app.infrastructure.springboot.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CardPackRarityTest {

    @Test
    void shouldCreateValidCardPackRarity() {
        RarityEntity rarityEntity = new RarityEntity(1L, "Common");
        CardPackEntity cardPackEntity = new CardPackEntity(1L, "Basic Pack", null, 100, 10, null);
        CardPackRarityId cardPackRarityId = new CardPackRarityId(cardPackEntity.getId(), rarityEntity.getId());
        CardPackRarity cardPackRarity = new CardPackRarity(cardPackRarityId, rarityEntity, cardPackEntity, 0.5);
        assertEquals(rarityEntity, cardPackRarity.getRarity());
        assertEquals(0.5, cardPackRarity.getRate());
    }

}
