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

    @Test
    void should_not_add_cards_to_player_when_cards_is_null() {
        List<CardEntity> cards = null;
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayer(cards, player);

        Mockito.verify(playerRepository, Mockito.times(0)).save(player);
    }

    @Test
    void should_not_add_cards_to_player_when_player_is_null() {
        List<CardEntity> cards = new ArrayList<>();
        PlayerEntity player = null;

        addCardsToPlayerService.addCardsToPlayer(cards, player);

        Mockito.verify(playerRepository, Mockito.times(0)).save(player);
    }

    @Test
    void should_have_3_cards_added() {
        List<CardEntity> cards = new ArrayList<>();
        cards.add(new CardEntity());
        cards.add(new CardEntity());
        cards.add(new CardEntity());
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayer(cards, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
        assert player.getDeck().getCards().size() == 3;
    }
}
