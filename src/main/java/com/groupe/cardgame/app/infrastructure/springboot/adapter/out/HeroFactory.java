package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.github.javafaker.Faker;
import com.groupe.cardgame.app.domain.Hero;
import com.groupe.cardgame.app.domain.Specialty;
import com.groupe.cardgame.app.domain.model.Rarity;

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
                rarity,
                specialty
        );
    }

    public static Hero createRandomHero() {
        String name = faker.name().fullName();
        Rarity rarity = Rarity.values()[faker.number().numberBetween(0, Rarity.values().length)];
        Specialty specialty =  Specialty.values()[faker.number().numberBetween(0, Specialty.values().length)];
        return createHero(name, rarity, specialty);
    }

}
