package com.groupe.cardgame.app.domain;

import java.util.Objects;

public class Rarity {
    private String name;

    public Rarity(String name) {
        this.name = name;
    }


    public static Rarity byName(String name) {
        return new Rarity(name);
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rarity rarity)) return false;
        return Objects.equals(name, rarity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}