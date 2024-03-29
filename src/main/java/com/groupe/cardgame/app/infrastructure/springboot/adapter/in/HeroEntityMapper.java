package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.domain.model.Hero;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeroEntityMapper {
    public HeroEntity toEntity(Hero hero) {
        return new HeroEntity(
                null,
                hero.getName(),
                hero.getHealth(),
                hero.getAttackLevel(),
                hero.getArmorLevel(),
                hero.getLevel(),
                RarityEntityMapper.toEntity(hero.getRarity()),
                SpecialtyEntityMapper.toEntity(hero.getSpecialty())
        );
    }

    public List<HeroEntity> toEntity(List<Hero> heroes) {
        return heroes.stream().map(this::toEntity).toList();
    }
}
