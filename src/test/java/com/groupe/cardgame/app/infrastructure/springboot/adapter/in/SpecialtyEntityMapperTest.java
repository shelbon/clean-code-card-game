package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.domain.model.Specialty;
import com.groupe.cardgame.app.infrastructure.springboot.models.SpecialtyEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
class SpecialtyEntityMapperTest {
    @Test
    void can_convert_to_entity() {
         var specialtyEntity=SpecialtyEntityMapper.toEntity(Specialty.TANK);
         assertThat(specialtyEntity).isNotNull();
             }
}