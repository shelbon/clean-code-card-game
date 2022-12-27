package com.groupe.cardgame.app.infra.springboot.adapter.out;

import com.groupe.cardgame.app.infra.springboot.models.CardPackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardPackRepository  extends JpaRepository<CardPackEntity, Long> {

}