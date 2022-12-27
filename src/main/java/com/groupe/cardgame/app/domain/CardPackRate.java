package com.groupe.cardgame.app.domain;
import com.groupe.cardgame.app.domain.model.Rarity;
import java.util.Objects;

public record CardPackRate(Rarity rarity, double rate) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPackRate that)) return false;
        return Double.compare(that.rate, rate) == 0 && Objects.equals(rarity, that.rarity);
    }
}