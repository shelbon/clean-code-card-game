package com.groupe.cardgame.app.domain.model;

class Specialty {
    private String name;
    private int startingHealth;
    private int startingPower;
    private int startingArmor;
    private int extraPowerAgainst;

    public Specialty(String name, int startingHealth, int startingPower, int startingArmor, int extraPowerAgainst) {
        this.name = name;
        this.startingHealth = startingHealth;
        this.startingPower = startingPower;
        this.startingArmor = startingArmor;
        this.extraPowerAgainst = extraPowerAgainst;
    }

    public String getName() {
        return name;
    }

    public int getStartingHealth() {
        return startingHealth;
    }

    public int getStartingPower() {
        return startingPower;
    }

    public int getStartingArmor() {
        return startingArmor;
    }

    public int getExtraPowerAgainst() {
        return extraPowerAgainst;
    }
}