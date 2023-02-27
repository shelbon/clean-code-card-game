package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    void addHero() {
        // Créer un deck et ajouter un héros
        Deck deck = new Deck();
        Hero hero = new Hero("nom", 100, 0, 10, 10, 1, Specialty.MAGE, Rarity.COMMON);
        deck.addHero(hero);

        // Vérifier si le héros a été ajouté
        List<Hero> heroes = deck.getHeroes();
        assertEquals(1, heroes.size());
        assertTrue(heroes.contains(hero));
    }

    @Test
    void getHeroes() {
        // Créer un deck vide
        Deck deck = new Deck();

        // Vérifier si le deck est vide
        List<Hero> heroes = deck.getHeroes();
        assertTrue(heroes.isEmpty());

        // Ajouter un héros au deck
        Hero hero = new Hero("nom", 100, 0, 10, 10, 1, Specialty.MAGE, Rarity.COMMON);
        deck.addHero(hero);

        // Vérifier si le héros a été ajouté
        heroes = deck.getHeroes();
        assertEquals(1, heroes.size());
        assertTrue(heroes.contains(hero));
    }
}
