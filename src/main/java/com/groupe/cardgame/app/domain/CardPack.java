package com.groupe.cardgame.app.domain;


import java.util.List;

public class CardPack {
    private final String name;
    private final List<Hero> cards;
    private final int tokenCost;
    private final int cardCount;
    private final List<CardPackRate> rates;

    public CardPack(String name, List<Hero> cards, int tokenCost, int cardCount, List<CardPackRate> rates) {
        this.name = name;
        this.cards = cards;
        this.tokenCost = tokenCost;
        this.cardCount = cardCount;
        this.rates = rates;
    }

    public List<CardPackRate> probabilityByRates() {
        return rates;
    }

    public List<Hero> cards() {
        return cards;
    }

    public int cardPerPull() {
        return cardCount;
    }
}