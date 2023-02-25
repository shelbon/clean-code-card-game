package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository  extends JpaRepository<CardEntity, Long> {
}