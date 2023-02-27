package com.groupe.cardgame.app.infrastructure.springboot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor()
@Table(name = "CARD_PACK")
public class CardPackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private final Long id;
    private final String name;
    @ManyToMany(cascade = CascadeType.ALL)
    private final List<HeroEntity> cards;
    private final int tokenCost;
    private final int cardCount;
    @OneToMany(mappedBy = "cardPack", cascade = CascadeType.ALL)

    private final List<CardPackRarity> cardPackRarities;

    public void addCard(HeroEntity hero) {
        cards.add(hero);
    }

    public void addCards(List<HeroEntity> heroes) {
        cards.addAll(heroes);
    }

    public void setCardPackRarities(List<CardPackRarity> newCardPackRarities) {
        Objects.requireNonNull(cardPackRarities).addAll(newCardPackRarities);
    }

    public CardPackEntity(String name, int tokenCost, int cardCount) {
        this.name = name;
        this.tokenCost = tokenCost;
        this.cardCount = cardCount;
        this.cards = List.of();
        this.cardPackRarities = List.of();
        this.id = null;

    }
}