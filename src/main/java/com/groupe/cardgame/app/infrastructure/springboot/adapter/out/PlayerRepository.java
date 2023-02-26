package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.DTO.SimplePlayerInfo;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}