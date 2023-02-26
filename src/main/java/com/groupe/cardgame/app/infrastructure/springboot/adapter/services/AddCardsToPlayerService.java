package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public final class AddCardsToPlayerService {
    private final PlayerRepository playerRepository;
    public void addCardsToPlayer(List<CardEntity> cards, PlayerEntity player){
        Objects.requireNonNull(player);
        Objects.requireNonNull(player.getDeck());
        player.getDeck().addCards(cards);
        playerRepository.save(player);
    }
}