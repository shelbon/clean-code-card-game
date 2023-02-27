package com.groupe.cardgame.app.infrastructure.springboot.models;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor(force = true)

@Table(name = "CARD_PACK_RATES")
public class CardPackRarity {
    @EmbeddedId
    private final CardPackRarityId id;
    @ManyToOne
    @JoinColumn(name = "rarity_id",insertable = false,updatable = false)
    private final RarityEntity rarity;
    @ManyToOne
    @MapsId("cardPackId")
    private final CardPackEntity cardPack;

    private final double rate;


    public RarityEntity getRarity() {
        return rarity;
    }
    public double getRate() {
        return rate;
    }


}