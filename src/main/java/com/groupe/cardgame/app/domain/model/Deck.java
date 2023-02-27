package com.groupe.cardgame.app.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Hero> heroes;

    public Deck() {
        heroes = new ArrayList<>();
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}

