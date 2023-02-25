package com.groupe.cardgame.app.domain.model;

public class Hero {
    private String name;
    private int health;
    private int experiencePoints;
    private int attackLevel;
    private int armorLevel;
    private int level;
    private Specialty specialty;
    private Rarity rarity;

    public Hero(String name, int health, int experiencePoints, int attackLevel, int armorLevel, int level, Specialty specialty, Rarity rarity) {
        this.name = name;
        this.health = health;
        this.experiencePoints = experiencePoints;
        this.attackLevel = attackLevel;
        this.armorLevel = armorLevel;
        this.level = level;
        this.specialty = specialty;
        this.rarity = rarity;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getArmorLevel() {
        return armorLevel;
    }

    public void setArmorLevel(int armorLevel) {
        this.armorLevel = armorLevel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperiencePoints() {
        return experiencePoints;
    }

    public void setExperiencePoints(int experiencePoints) {
        this.experiencePoints = experiencePoints;
    }

    public void takeDamageFrom(Hero attacker) {
        int damage = Math.max(0, attacker.getAttackLevel() - armorLevel);
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public void setRarity(Rarity rarity) {
        this.rarity = rarity;
    }
}