package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.mapper;

import com.groupe.cardgame.app.application.port.in.CreatePlayerQuery;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.DTO.SimplePlayerInfo;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.springframework.stereotype.Component;

@Component
public class PlayerEntityMapper {
    public PlayerEntity toEntity(CreatePlayerQuery createPlayerQuery) {
        return new PlayerEntity(createPlayerQuery.username());
    }

    public SimplePlayerInfo fromEntityToSimplePlayerInfo(PlayerEntity playerEntity) {
        return new SimplePlayerInfo(playerEntity.getId(), playerEntity.getUsername());
    }

}