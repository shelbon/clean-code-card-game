package com.groupe.cardgame.app.infrastructure.springboot.models;

import com.groupe.cardgame.app.domain.model.Rarity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CardPackEntityTest {

    private CardPackEntity cardPack;
    private List<HeroEntity> cards;
    private List<CardPackRarity> cardPackRarities;

    @BeforeEach
    void setUp() {
        cards = new ArrayList<>();
        cardPackRarities = new ArrayList<>();
        cardPack = new CardPackEntity(1L, "Test Pack", cards, 10, 5, cardPackRarities);
    }

    @Test
    void shouldAddCardToCardPack() {
        HeroEntity hero = new HeroEntity();
        cardPack.addCard(hero);
        assertEquals(1, cardPack.getCards().size());
        assertEquals(hero, cardPack.getCards().get(0));
    }

    @Test
    void shouldAddCardsToCardPack() {
        List<HeroEntity> heroes = List.of(new HeroEntity(), new HeroEntity());
        cardPack.addCards(heroes);
        assertEquals(2, cardPack.getCards().size());
        assertEquals(heroes, cardPack.getCards());
    }

}
