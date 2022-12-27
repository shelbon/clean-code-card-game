package com.groupe.cardgame.app.domain;

public final class Speciality {
    private String name;
    private int healthPointsAtLevel1;
    private int attackPowerAtLevel1;
    private int armorPointsAtLevel1;
    private int additionalAttackPowerAgainstWeakestSpeciality;
    private String weakerSpeciality;


    public Speciality(String name, int healthPointsAtLevel1, int attackPowerAtLevel1, int armorPointsAtLevel1, int additionalAttackPowerAgainstWeakestSpeciality, String weakestSpeciality) {
        this.name = name;
        this.healthPointsAtLevel1 = healthPointsAtLevel1;
        this.attackPowerAtLevel1 = attackPowerAtLevel1;
        this.armorPointsAtLevel1 = armorPointsAtLevel1;
        this.additionalAttackPowerAgainstWeakestSpeciality = additionalAttackPowerAgainstWeakestSpeciality;
        this.weakerSpeciality = weakestSpeciality;
    }

    public String name() {
        return name;
    }

    public int healthPointsAtLevel1() {
        return healthPointsAtLevel1;
    }

    public int attackPowerAtLevel1() {
        return attackPowerAtLevel1;
    }

    public int armorPointsAtLevel1() {
        return armorPointsAtLevel1;
    }

    public int additionalAttackPowerAgainstWeakestSpeciality() {
        return additionalAttackPowerAgainstWeakestSpeciality;
    }

    public String weakestSpeciality() {
        return weakerSpeciality;
    }
}