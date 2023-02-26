package com.groupe.cardgame.app;

import com.github.javafaker.Faker;
import com.groupe.cardgame.app.domain.model.Rarity;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.RarityEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.SpecialtyEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class HeroFactory {


    private Faker faker;
    private Random rand;

    public HeroFactory() {
        faker = new Faker();
        rand = new Random();
    }

    public List<HeroEntity> generateHeroes() {
        List<HeroEntity> cardList=new ArrayList<>();
        List<RarityEntity> rarityList = generateRarityEntity();
        List<SpecialtyEntity> specialityList = generateSpecialityEntity();
        Set<String> givenRarity = new HashSet<>();
        int neededNumberOfCard = faker.number().randomDigitNotZero() + rarityList.size();
        while (givenRarity.size() < rarityList.size() || cardList.size() < neededNumberOfCard) {
            int index = rand.nextInt(rarityList.size());
            int indexSpeciality = (rand.nextInt(specialityList.size()));
            RarityEntity rarity = rarityList.get(index);
             givenRarity.add(rarity.getName());
            SpecialtyEntity speciality = specialityList.get(indexSpeciality);
            cardList.add(new HeroEntity(faker.number().randomNumber(), faker.name().firstName(), speciality.healthPointsAtLevel1(), speciality.attackPowerAtLevel1(), speciality.armorPointsAtLevel1(), 1, rarity, speciality));
        }
        return cardList;
    }

    private List<RarityEntity> generateRarityEntity() {
        var rarityList = List.of(Rarity.values());
        return IntStream.range(0, rarityList.size())
                .mapToObj(i -> new RarityEntity((long) i, rarityList.get(i).name()))
                .collect(Collectors.toList());
    }
    private List<SpecialtyEntity> generateSpecialityEntity() {
        return List.of(new SpecialtyEntity(0L, "Tank", 1000, 100, 20, 20, "Mage")
                , new SpecialtyEntity(1L, "Assasin", 800, 200, 5, 30, "Tank"),
                   new SpecialtyEntity(2L, "Mage", 700, 150, 10, 25, "Assasin"));
    }
}