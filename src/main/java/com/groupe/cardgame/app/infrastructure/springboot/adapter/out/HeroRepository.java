package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository  extends JpaRepository<HeroEntity, Long> {
}