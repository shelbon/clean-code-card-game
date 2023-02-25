package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {

}