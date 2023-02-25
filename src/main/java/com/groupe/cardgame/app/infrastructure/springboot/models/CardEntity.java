package com.groupe.cardgame.app.infrastructure.springboot.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CARDS")
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Getter
@Setter
public class CardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private final Long id;
    private  final String name;
    private final int health;
    private final int attackPoints;
    private final int armorPoints;
    private final int level;
    @ManyToOne
    private final RarityEntity rarity;
    @ManyToOne
    private final SpecialtyEntity speciality;
}