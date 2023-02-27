package com.groupe.cardgame.app.infrastructure.springboot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name = "PLAYER",
        uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public final class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private int numberOfTokens;
    @OneToOne(cascade = CascadeType.ALL)
    private DeckEntity deck;

    public PlayerEntity(String username) {
        this.username = username;
        this.deck = new DeckEntity(this);
        this.numberOfTokens = 4;
    }

    public PlayerEntity(String username, DeckEntity deck) {
        this.username = username;
        this.deck = deck;
        this.numberOfTokens = 4;
    }

    public PlayerEntity(long id, String username, DeckEntity deck) {
        this.id = id;
        this.username = username;
        this.deck = deck;
        this.numberOfTokens = 4;
    }

    public void updateNumberOfTokens(int newNumberOfTokens) {
        this.numberOfTokens = newNumberOfTokens;
    }
}