package com.groupe.cardgame.app.infrastructure.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Table(name = "DECK")
public class DeckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String name;
    @ManyToMany
    private final List<CardEntity> cards;
    @OneToOne
    private final PlayerEntity player;

    public void addCards(List<CardEntity> cards) {
        Objects.requireNonNull(this.cards).addAll(cards);
    }

    public DeckEntity() {
        this.cards = new ArrayList<>();
        this.id = null;
        this.name = null;
        this.player = null;
    }

    public DeckEntity(PlayerEntity playerEntity) {
        this.cards = new ArrayList<>();
        this.id = null;
        this.name = null;
        this.player = playerEntity;
    }

    public List<CardEntity> getCards() {
        return cards;
    }
}