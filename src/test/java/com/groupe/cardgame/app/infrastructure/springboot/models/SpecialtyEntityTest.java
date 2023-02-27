package com.groupe.cardgame.app.infrastructure.springboot.models;

import com.groupe.cardgame.app.infrastructure.springboot.models.SpecialtyEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialtyEntityTest {
    @Test
    public void constructor_shouldCreateSpecialtyEntity() {
        SpecialtyEntity specialty = new SpecialtyEntity(1L, "test", 10, 20, 30, 5, "weakest");

        assertEquals(1L, specialty.getId());
        assertEquals("test", specialty.name());
        assertEquals(10, specialty.healthPointsAtLevel1());
        assertEquals(20, specialty.attackPowerAtLevel1());
        assertEquals(30, specialty.armorPointsAtLevel1());
        assertEquals(5, specialty.additionalAttackPowerAgainstWeakestSpeciality());
        assertEquals("weakest", specialty.weakestSpeciality());
    }
}
