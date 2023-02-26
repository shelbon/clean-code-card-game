package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public final class AddHeroesToPlayerDeckService {
    private final PlayerRepository playerRepository;

    public void addHeroesToPlayerDeck(List<HeroEntity> heroes, PlayerEntity player) {
        Objects.requireNonNull(player);
        Objects.requireNonNull(player.getDeck());
        Objects.requireNonNull(heroes);
        player.getDeck().addCards(heroes);
        playerRepository.save(player);
    }
}