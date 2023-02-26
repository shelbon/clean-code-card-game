package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardPackTest {

    @Test
    void testCreation() {
        CardPack cardPack = new CardPack(Rarity.COMMON, 3);
        Assertions.assertEquals(Rarity.COMMON, cardPack.getRarity());
        Assertions.assertEquals(3, cardPack.getPackSize());
        Assertions.assertTrue(cardPack.getHeroes().isEmpty());
    }
}
