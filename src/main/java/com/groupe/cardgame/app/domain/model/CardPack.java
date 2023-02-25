package com.groupe.cardgame.app.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardPack {
    private static final Random RANDOM = new Random();

    private List<Hero> heroes = new ArrayList<>();
    private Rarity rarity;
    private int packSize;

    public CardPack(Rarity rarity, int packSize) {
        this.rarity = rarity;
        this.packSize = packSize;
        openPack();
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public int getPackSize() {
        return packSize;
    }

    private void openPack() {
        for (int i = 0; i < packSize; i++) {
            heroes.add(generateHero());
        }
    }

    private Hero generateHero() {
        int value = RANDOM.nextInt(100) + 1;
        if (value <= rarity.getLegendaryProbability()) {
            return HeroFactory.createRandomHero(Rarity.LEGENDARY);
        } else if (value <= rarity.getRareProbability()) {
            return HeroFactory.createRandomHero(Rarity.RARE);
        } else {
            return HeroFactory.createRandomHero(Rarity.COMMON);
        }
    }

}
