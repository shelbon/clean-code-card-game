package com.groupe.cardgame.app.infrastructure.springboot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Table(name ="DECK" )
public class DeckEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final String name;
    @ManyToMany
    private final List<HeroEntity> heroes;
    @OneToOne
    private final PlayerEntity player;
    public void addCards(List<HeroEntity> cards) {
        Objects.requireNonNull(this.heroes).addAll(cards);
    }

    public List<HeroEntity> getCards() {
        return heroes;
    }
}