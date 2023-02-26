package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {
    @Test
    void takeDamageFrom() {
        Hero attacker = new Hero("Attacker", 100, 0, 50, 0, 1, Specialty.TANK, Rarity.COMMON);
        Hero defender = new Hero("Defender", 100, 0, 0, 20, 1, Specialty.ASSASSIN, Rarity.COMMON);
        defender.takeDamageFrom(attacker);
        assertEquals(70, defender.getHealth());
    }

    @Test
    void gettersAndSetters() {
        Hero hero = new Hero("TestHero", 100, 0, 50, 20, 1, Specialty.TANK, Rarity.COMMON);
        hero.setHealth(80);
        hero.setExperiencePoints(10);
        hero.setAttackLevel(30);
        hero.setArmorLevel(15);
        hero.setLevel(2);
        hero.setSpecialty(Specialty.ASSASSIN);
        hero.setRarity(Rarity.LEGENDARY);

        assertEquals("TestHero", hero.getName());
        assertEquals(80, hero.getHealth());
        assertEquals(10, hero.getExperiencePoints());
        assertEquals(30, hero.getAttackLevel());
        assertEquals(15, hero.getArmorLevel());
        assertEquals(2, hero.getLevel());
        assertEquals(Specialty.ASSASSIN, hero.getSpecialty());
        assertEquals(Rarity.LEGENDARY, hero.getRarity());
    }
}
