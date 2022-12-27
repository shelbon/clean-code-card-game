package com.groupe.cardgame.app.infra.springboot.adapter.out;

import com.groupe.cardgame.app.infra.springboot.models.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity,Long> {

}