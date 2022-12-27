package com.groupe.cardgame.app.infra.springboot.adapter.out;

import com.groupe.cardgame.app.infra.springboot.adapter.in.exception.CardPackEmptyException;
import com.groupe.cardgame.app.infra.springboot.models.CardEntity;
import com.groupe.cardgame.app.infra.springboot.models.CardPackEntity;
import com.groupe.cardgame.app.infra.springboot.models.CardPackRarity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public final class CardPullService {

    private final Random random;

    public CardPullService() {
        this.random = new Random();
    }


    private List<CardEntity> pull(CardPackEntity packOfCard) {
        if (packOfCard.getCards().isEmpty()) {
           throw new CardPackEmptyException("Card pack is empty");
        }
        List<CardPackRarity> probabilityByRates = packOfCard.getCardPackRarities();
        Collections.shuffle(probabilityByRates);
        List<CardEntity> pulledCard = new ArrayList<>();
        for (int i = 0; i < packOfCard.getCardCount(); i++) {
            double randProbabilty = random.nextDouble(1.0);
            String rarityToPull = "";
            while (rarityToPull.isEmpty()) {

                for (int j = 0; j < probabilityByRates.size(); j++) {
                    CardPackRarity probabilityByRate = probabilityByRates.get(j);
                    if (randProbabilty < probabilityByRate.getRate() || j == probabilityByRates.size() - 1) {
                        rarityToPull = probabilityByRate
                                .getRarity().getName();
                        break;
                    }
                }

                if (rarityToPull.isEmpty()) {
                    randProbabilty = random.nextDouble(1.0);
                }
            }
            String finalRarityToPull = rarityToPull;
            List<CardEntity> pullOfCardToPull = packOfCard.getCards().stream()
                    .filter(hero -> hero
                            .getRarity().getName()
                            .equals(finalRarityToPull))
                    .toList();
            int numberToPeek = random.nextInt(pullOfCardToPull.size());
            pulledCard.add(pullOfCardToPull.get(numberToPeek));
        }
        return pulledCard;

    }


    public java.util.List<CardEntity> pullXTimes(CardPackEntity packOfHero, int numberOfTimes) {
        List<CardEntity> result = new ArrayList<>();
        for (int i = 0; i < numberOfTimes; i++) {
            result.addAll(pull(packOfHero));
        }
        return result;
    }
}