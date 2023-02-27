package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.DTO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplePlayerInfoTest {
     @Test
      void can_create_a_simple_player_info() {

         SimplePlayerInfo simplePlayerInfo = new SimplePlayerInfo(1L,"bob");

         assertNotNull(simplePlayerInfo);
     }
}