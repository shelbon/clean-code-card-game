package com.groupe.cardgame.app;

import com.groupe.cardgame.app.domain.model.Rarity;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackRarity;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackRarityId;
import com.groupe.cardgame.app.infrastructure.springboot.models.RarityEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.SpecialtyEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;


public class CardPackFactory {


    private HeroFactory cardFactory;

    public CardPackFactory(HeroFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    private java.util.List<RarityEntity> generateRarityEntity() {
        var rarityList = List.of(Rarity.values());
        return LongStream.range(0L, rarityList.size())
                .mapToObj(i -> new RarityEntity(i, rarityList.get((int) i).name()))
                .collect(Collectors.toList());
    }

    private java.util.List<SpecialtyEntity> generateSpecialityEntity() {
        return java.util.List.of(new SpecialtyEntity(0L, "Tank", 1000, 100, 20, 20, "Mage")
                , new SpecialtyEntity(1L, "Assasin", 800, 200, 5, 30, "Tank"),
                new SpecialtyEntity(2L, "Mage", 700, 150, 10, 25, "Assasin"));
    }


    public CardPackEntity generateCardPack() {
        var cards = cardFactory.generateHeroes();
        var rarities = this.generateRarityEntity();
        var cardPackEntity = new CardPackEntity(0L, "Pack argent", cards, 1, 3, new ArrayList<>());
        Double[] probability = new Double[]{0.75, 0.20, 0.05};
        var cardPackRarities = LongStream.range(0, rarities.size())
                .mapToObj(i -> new CardPackRarity(new CardPackRarityId(i, 0L), rarities.get((int) i), cardPackEntity, probability[(int) i]))
                .toList();
        cardPackEntity.getCardPackRarities().addAll(cardPackRarities);
        return cardPackEntity;


    }
}