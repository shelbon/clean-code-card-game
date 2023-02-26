package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class HeroFactoryTest {
    @Test
    void createHero() {
        Hero hero = HeroFactory.createHero("TestHero", Rarity.COMMON, Specialty.ASSASSIN);
        assertEquals("TestHero", hero.getName());
        assertEquals(Rarity.COMMON, hero.getRarity());
        assertEquals(Specialty.ASSASSIN, hero.getSpecialty());
        assertEquals(1, hero.getLevel());
        assertEquals(800, hero.getHealth());
        assertEquals(0, hero.getExperiencePoints());
        assertEquals(200, hero.getAttackLevel());
        assertEquals(5, hero.getArmorLevel());
    }

    @Test
    void createRandomHero() {
        Hero hero = HeroFactory.createRandomHero();
        assertNotNull(hero.getName());
        assertNotNull(hero.getRarity());
        assertNotNull(hero.getSpecialty());
        assertEquals(1, hero.getLevel());
        assertTrue(hero.getHealth() > 0);
        assertEquals(0, hero.getExperiencePoints());
        assertTrue(hero.getAttackLevel() > 0);
        assertTrue(hero.getArmorLevel() > 0);
    }

    @Test
    void createRandomHeroes() {
        List<Hero> heroes = HeroFactory.createRandomHeroes(3);
        assertEquals(3, heroes.size());
        for (Hero hero : heroes) {
            assertNotNull(hero.getName());
            assertNotNull(hero.getRarity());
            assertNotNull(hero.getSpecialty());
            assertEquals(1, hero.getLevel());
            assertTrue(hero.getHealth() > 0);
            assertEquals(0, hero.getExperiencePoints());
            assertTrue(hero.getAttackLevel() > 0);
            assertTrue(hero.getArmorLevel() > 0);
        }
    }
}
