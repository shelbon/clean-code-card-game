package com.groupe.cardgame.app.infra.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class CardPackRarityId implements Serializable {
    @Column(name = "rarity_id")
    private Long rarityId;
    @Column(name = "card_pack_id")
    private Long cardPackId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPackRarityId that)) return false;
        return rarityId == that.rarityId && cardPackId == that.cardPackId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rarityId, cardPackId);
    }
}