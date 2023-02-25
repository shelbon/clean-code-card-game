package com.groupe.cardgame.app.domain;

public enum Specialty {
    TANK(1000, 20, 100, 20, "ASSASSIN"),
    MAGE(700, 10, 150, 25, "TANK"),
    ASSASSIN(800, 5, 200, 30, "MAGE");

    private int healthPointsAtLevel1;
    private int armorPointsAtLevel1;
    private int attackPowerAtLevel1;
    private int additionalAttackPowerAgainstWeakestSpeciality;
    private String weakerSpeciality;

    Specialty(int healthPointsAtLevel1, int armorPointsAtLevel1, int attackPowerAtLevel1,
              int additionalAttackPowerAgainstWeakestSpeciality, String weakerSpeciality) {
        this.healthPointsAtLevel1 = healthPointsAtLevel1;
        this.armorPointsAtLevel1 = armorPointsAtLevel1;
        this.attackPowerAtLevel1 = attackPowerAtLevel1;
        this.additionalAttackPowerAgainstWeakestSpeciality = additionalAttackPowerAgainstWeakestSpeciality;
        this.weakerSpeciality = weakerSpeciality;
    }

    public int healthPointsAtLevel1() {
        return healthPointsAtLevel1;
    }

    public int armorPointsAtLevel1() {
        return armorPointsAtLevel1;
    }

    public int attackPowerAtLevel1() {
        return attackPowerAtLevel1;
    }

    public int additionalAttackPowerAgainstWeakestSpeciality() {
        return additionalAttackPowerAgainstWeakestSpeciality;
    }

    public String weakerSpeciality() {
        return weakerSpeciality;
    }
}
