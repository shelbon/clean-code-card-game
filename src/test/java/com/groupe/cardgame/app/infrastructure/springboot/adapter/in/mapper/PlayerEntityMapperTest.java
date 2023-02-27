package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.mapper;

import com.groupe.cardgame.app.application.port.in.CreatePlayerQuery;
import com.groupe.cardgame.app.domain.model.Player;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.DTO.SimplePlayerInfo;
import com.groupe.cardgame.app.infrastructure.springboot.models.DeckEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class PlayerEntityMapperTest {
    @Test
   void can_create_a_player_entity_mapper() {
       PlayerEntityMapper playerEntityMapper = new PlayerEntityMapper();
       assertNotNull(playerEntityMapper);
   }
   @Test
   void can_convert_to_entity() {
       PlayerEntityMapper playerEntityMapper = new PlayerEntityMapper();
       CreatePlayerQuery createPlayerQuery = new CreatePlayerQuery("username");
       PlayerEntity playerEntity = playerEntityMapper.toEntity(createPlayerQuery);
        assertThat(playerEntity).isNotNull();
        assertThat(playerEntity.getUsername()).isEqualTo(createPlayerQuery.username());
        assertThat(playerEntity.getNumberOfTokens()).isGreaterThanOrEqualTo(4);


   }
   @Test
   void can_convert_to_simple_player_info_dto() {
       PlayerEntityMapper playerEntityMapper = new PlayerEntityMapper();
       PlayerEntity playerEntity = new PlayerEntity(1L,"bob",new DeckEntity());
       SimplePlayerInfo simplePlayerInfoDto = playerEntityMapper.fromEntityToSimplePlayerInfo(playerEntity);
       assertThat(simplePlayerInfoDto).isNotNull();
       assertThat(simplePlayerInfoDto.username()).isEqualTo(playerEntity.getUsername());
       assertThat(playerEntity.getId()).isEqualTo(playerEntity.getId());
   }
}