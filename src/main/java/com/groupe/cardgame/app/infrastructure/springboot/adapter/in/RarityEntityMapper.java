package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.domain.model.Rarity;
import com.groupe.cardgame.app.infrastructure.springboot.models.RarityEntity;
import org.springframework.stereotype.Component;

@Component
public class RarityEntityMapper {
    public static RarityEntity toEntity(Rarity rarity) {
        return new RarityEntity(
                null,
                rarity.name()
        );
    }

}
