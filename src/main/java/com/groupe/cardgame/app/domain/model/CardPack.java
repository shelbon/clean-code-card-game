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

}