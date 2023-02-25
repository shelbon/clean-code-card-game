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
    @ManyToMany
    private final List<CardEntity> cards;
    private final int tokenCost;
    private final int cardCount;
    @OneToMany(mappedBy = "cardPack", cascade = CascadeType.ALL)

    private  final List<CardPackRarity> cardPackRarities;

    public void addCard(CardEntity card) {
        cards.add(card);
    }

    public void addCards(List<CardEntity> cards) {
        cards.addAll(cards);
    }

    public void setCardPackRarities(List<CardPackRarity> newCardPackRarities) {
        Objects.requireNonNull(cardPackRarities).addAll(newCardPackRarities);
    }
}