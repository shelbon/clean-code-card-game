package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class AddHeroesToPlayerService {
    private final PlayerRepository playerRepository;
    public void addCardsToPlayer(List<HeroEntity> heroes, PlayerEntity player){
        player.getDeck().addCards(heroes);
        playerRepository.save(player);
    }
}