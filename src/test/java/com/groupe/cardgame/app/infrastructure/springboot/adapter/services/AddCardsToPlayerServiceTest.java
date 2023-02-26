package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.DeckEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class AddCardsToPlayerServiceTest {

    @InjectMocks
    private AddCardsToPlayerService addCardsToPlayerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void should_add_cards_to_player() {
        List<CardEntity> cards = new ArrayList<>();
        PlayerEntity player = new PlayerEntity("bob",new DeckEntity());
        addCardsToPlayerService.addCardsToPlayer(cards, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
    }

    @Test
    void should_not_add_cards_to_player_when_cards_is_null() {
        List<CardEntity> cards = null;
        PlayerEntity player = new PlayerEntity();
        assertThatThrownBy(() -> addCardsToPlayerService.addCardsToPlayer(cards, player))
                .isInstanceOf(NullPointerException.class);

    }

    @Test
    void should_not_add_cards_to_player_when_player_is_null() {
        List<CardEntity> cards = new ArrayList<>();
        PlayerEntity player = null;
        assertThatThrownBy(() -> addCardsToPlayerService.addCardsToPlayer(cards, player))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    void should_have_3_cards_added() {
        List<CardEntity> cards = new ArrayList<>();
        cards.add(new CardEntity());
        cards.add(new CardEntity());
        cards.add(new CardEntity());
        PlayerEntity player = new PlayerEntity("bob",new DeckEntity());

        addCardsToPlayerService.addCardsToPlayer(cards, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
        assertThat(player.getDeck().getCards())
                .hasSize(3);
    }
}