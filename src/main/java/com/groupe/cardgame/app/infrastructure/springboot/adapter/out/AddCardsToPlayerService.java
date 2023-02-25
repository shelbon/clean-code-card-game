package com.groupe.cardgame.app.infrastructure.springboot.adapter.out;

import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public final class AddCardsToPlayerService {
    private final PlayerRepository playerRepository;
    public void addCardsToPlayer(List<CardEntity> cards, PlayerEntity player){
        player.getDeck().addCards(cards);
        playerRepository.save(player);
    }
}