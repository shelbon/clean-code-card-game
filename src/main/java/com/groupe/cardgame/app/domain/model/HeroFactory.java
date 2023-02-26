package com.groupe.cardgame.app.domain.model;

import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

public class HeroFactory {
    private static final Faker faker = new Faker();

    public static Hero createHero(String name, Rarity rarity, Specialty specialty) {
        int level = 1;
        int healthPoints = specialty.healthPointsAtLevel1();
        int armorPoints = specialty.armorPointsAtLevel1();
        int attackPower = specialty.attackPowerAtLevel1();

        return new Hero(
                        name,
                        level,
                        healthPoints,
                        0,
                        armorPoints,
                        attackPower,
                specialty,
                rarity
                );
    }

    public static Hero createRandomHero() {
        String name = faker.name().fullName();
        Rarity rarity = Rarity.values()[faker.number().numberBetween(0, Rarity.values().length)];
        Specialty specialty =  Specialty.values()[faker.number().numberBetween(0, Specialty.values().length)];
        return createHero(name, rarity, specialty);
    }

    public static List<Hero> createRandomHeroes(int numberOfHeroes) {
        List<Hero> heroes = new ArrayList<>();
        for (int i = 0; i < numberOfHeroes; i++) {
            heroes.add(createRandomHero());
        }
        return heroes;
    }
}
