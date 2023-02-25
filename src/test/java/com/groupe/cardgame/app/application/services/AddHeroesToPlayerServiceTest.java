package com.groupe.cardgame.app.application.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.AddHeroesToPlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.HeroFactory;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AddHeroesToPlayerServiceTest {

    @InjectMocks
    private AddHeroesToPlayerService addCardsToPlayerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void should_add_heroes_to_player_deck() {
        List<HeroEntity> heroes = new ArrayList<>();
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayerDeck(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
    }

    @Test
    void should_not_add_heroes_to_player_when_heroes_is_null() {
        List<HeroEntity> heroes = null;
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayerDeck(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(0)).save(player);
    }

    @Test
    void should_not_add_heroes_to_player_deck_when_player_is_null() {
        List<HeroEntity> heroes = new ArrayList<>();
        PlayerEntity player = null;

        addCardsToPlayerService.addCardsToPlayerDeck(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(0)).save(player);
    }
}
