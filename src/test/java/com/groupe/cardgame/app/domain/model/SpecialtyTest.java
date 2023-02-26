package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpecialtyTest {

    @Test
    public void testHealthPointsAtLevel1() {
        assertEquals(1000, Specialty.TANK.healthPointsAtLevel1());
        assertEquals(700, Specialty.MAGE.healthPointsAtLevel1());
        assertEquals(800, Specialty.ASSASSIN.healthPointsAtLevel1());
    }

    @Test
    public void testArmorPointsAtLevel1() {
        assertEquals(20, Specialty.TANK.armorPointsAtLevel1());
        assertEquals(10, Specialty.MAGE.armorPointsAtLevel1());
        assertEquals(5, Specialty.ASSASSIN.armorPointsAtLevel1());
    }

    @Test
    public void testAttackPowerAtLevel1() {
        assertEquals(100, Specialty.TANK.attackPowerAtLevel1());
        assertEquals(150, Specialty.MAGE.attackPowerAtLevel1());
        assertEquals(200, Specialty.ASSASSIN.attackPowerAtLevel1());
    }

    @Test
    public void testAdditionalAttackPowerAgainstWeakestSpeciality() {
        assertEquals(20, Specialty.TANK.additionalAttackPowerAgainstWeakestSpeciality());
        assertEquals(25, Specialty.MAGE.additionalAttackPowerAgainstWeakestSpeciality());
        assertEquals(30, Specialty.ASSASSIN.additionalAttackPowerAgainstWeakestSpeciality());
    }

    @Test
    public void testWeakerSpeciality() {
        assertEquals("ASSASSIN", Specialty.TANK.weakerSpeciality());
        assertEquals("TANK", Specialty.MAGE.weakerSpeciality());
        assertEquals("MAGE", Specialty.ASSASSIN.weakerSpeciality());
    }
}
