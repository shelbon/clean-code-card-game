package com.groupe.cardgame.app.infrastructure.springboot.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class DeckEntityTest {
    @Test
    void addCards_shouldAddCardsToDeck() {
        // Arrange
        DeckEntity deck = new DeckEntity();
        List<HeroEntity> cards = new ArrayList<>();
        cards.add(mock(HeroEntity.class));
        cards.add(mock(HeroEntity.class));

        // Act
        deck.addCards(cards);

        // Assert
        assertEquals(cards, deck.getCards());
    }
}
