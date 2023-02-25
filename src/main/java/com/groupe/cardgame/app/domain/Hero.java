package com.groupe.cardgame.app.domain;
import com.groupe.cardgame.app.domain.model.Rarity;
import java.util.Objects;

public class Hero {
    private String name;
    private int level;
    private int healthPoints;
    private int experiencePoints;
    private int armorPoints;
    private int attackPower;
    private Rarity rarity;
    private Specialty speciality;

    public Hero(String name, Rarity rarity, Specialty speciality) {
        this.name = name;
        this.rarity = rarity;
        this.speciality = speciality;
        this.experiencePoints=0;
        this.level=1;
        initStats(speciality);
    }

    private void initStats(Specialty speciality) {
        healthPoints=speciality.healthPointsAtLevel1();
        armorPoints=speciality.armorPointsAtLevel1();
        attackPower=speciality.attackPowerAtLevel1();
    }

    public Hero(String name, int level, int healthPoints, int experiencePoints,
                int armorPoints, int attackPower,
                Rarity rarity, Specialty speciality) {
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.experiencePoints = experiencePoints;
        this.armorPoints = armorPoints;
        this.attackPower = attackPower;
        this.rarity = rarity;
        this.speciality = speciality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return level == hero.level && healthPoints == hero.healthPoints &&
                experiencePoints == hero.experiencePoints && armorPoints == hero.armorPoints
                && attackPower == hero.attackPower && Objects.equals(name, hero.name)
                && Objects.equals(rarity, hero.rarity)
                && Objects.equals(speciality, hero.speciality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, healthPoints, experiencePoints,
                armorPoints, attackPower, rarity, speciality);
    }

    public String rarityName() {
        return this.rarity.name();
    }
}