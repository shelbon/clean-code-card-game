package com.groupe.cardgame.app.domain.model;

public enum Rarity {
    COMMON(0), RARE(10), LEGENDARY(20);

    private int bonus;

    Rarity(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public int getLegendaryProbability() {
        return LEGENDARY.getBonus();
    }

    public int getRareProbability() {
        return RARE.getBonus() + LEGENDARY.getBonus();
    }

    public int getCommonProbability() {
        return COMMON.getBonus() + RARE.getBonus() + LEGENDARY.getBonus();
    }
}