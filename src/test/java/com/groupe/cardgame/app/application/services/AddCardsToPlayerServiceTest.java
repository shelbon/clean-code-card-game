package com.groupe.cardgame.app.application.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.AddCardsToPlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class AddCardsToPlayerServiceTest {

    @InjectMocks
    private AddCardsToPlayerService addCardsToPlayerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void should_add_cards_to_player() {
        List<CardEntity> cards = new ArrayList<>();
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayer(cards, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
    }
}
