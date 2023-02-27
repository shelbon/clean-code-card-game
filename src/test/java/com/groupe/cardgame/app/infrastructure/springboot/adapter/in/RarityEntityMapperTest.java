package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.domain.model.Rarity;
import com.groupe.cardgame.app.infrastructure.springboot.models.RarityEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class RarityEntityMapperTest {
    @Test
    void can_convert_entity_to_domain() {
        RarityEntity rarityEntity = RarityEntityMapper.toEntity(Rarity.COMMON);
        assertThat(rarityEntity).isNotNull();
        assertThat(rarityEntity.getName()).isEqualTo(Rarity.COMMON.name());
    }
}