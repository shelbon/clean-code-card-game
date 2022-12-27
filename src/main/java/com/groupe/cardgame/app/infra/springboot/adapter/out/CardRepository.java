package com.groupe.cardgame.app.infra.springboot.adapter.out;

import com.groupe.cardgame.app.infra.springboot.models.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository  extends JpaRepository<CardEntity, Long> {
}