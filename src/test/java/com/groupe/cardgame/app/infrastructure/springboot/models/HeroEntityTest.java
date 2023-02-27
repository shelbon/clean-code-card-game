package com.groupe.cardgame.app.infrastructure.springboot.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class HeroEntityTest {

    @Test
    public void constructor_shouldCreateHeroEntity() {
        // Arrange
        Long id = 1L;
        String name = "Superman";
        int health = 100;
        int attackPoints = 10;
        int armorPoints = 5;
        int level = 1;
        RarityEntity rarity = new RarityEntity(1L, "common");
        SpecialtyEntity specialty = new SpecialtyEntity();

        // Act
        HeroEntity hero = new HeroEntity(id, name, health, attackPoints, armorPoints, level, rarity, specialty);

        // Assert
        assertNotNull(hero);
        assertEquals(id, hero.getId());
        assertEquals(name, hero.getName());
        assertEquals(health, hero.getHealth());
        assertEquals(attackPoints, hero.getAttackPoints());
        assertEquals(armorPoints, hero.getArmorPoints());
        assertEquals(level, hero.getLevel());
        assertEquals(rarity, hero.getRarity());
        assertEquals(specialty, hero.getSpeciality());
    }

    @Test
    public void defaultConstructor_shouldCreateHeroEntityWithNullValues() {
        // Arrange

        // Act
        HeroEntity hero = new HeroEntity();

        // Assert
        assertNotNull(hero);
        assertEquals(null, hero.getId());
        assertEquals(null, hero.getName());
        assertEquals(0, hero.getHealth());
        assertEquals(0, hero.getAttackPoints());
        assertEquals(0, hero.getArmorPoints());
        assertEquals(0, hero.getLevel());
        assertEquals(null, hero.getRarity());
        assertEquals(null, hero.getSpeciality());
    }
}
