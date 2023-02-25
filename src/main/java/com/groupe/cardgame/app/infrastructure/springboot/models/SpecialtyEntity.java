package com.groupe.cardgame.app.infrastructure.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Table(name = "SPECIALTY")
public class SpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String name;
    private final int healthPointsAtLevel1;
    private final int attackPowerAtLevel1;
    private final int armorPointsAtLevel1;
    private final int additionalAttackPowerAgainstWeakestSpeciality;
    private final String weakerSpeciality;


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