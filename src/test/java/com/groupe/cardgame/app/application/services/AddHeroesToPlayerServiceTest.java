package com.groupe.cardgame.app.application.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.AddCardsToPlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
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
class AddHeroToPlayerServiceTest {

    @InjectMocks
    private AddCardsToPlayerService addCardsToPlayerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void should_add_heroes_to_player_deck() {
        List<HeroEntity> heroes = new ArrayList<>();
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayer(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
    }

    @Test
    void should_not_add_heroes_to_player_when_heroes_is_null() {
        List<HeroEntity> heroes = null;
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayer(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(0)).save(player);
    }

    @Test
    void should_not_add_heroes_to_player_deck_when_player_is_null() {
        List<HeroEntity> heroes = new ArrayList<>();
        PlayerEntity player = null;

        addCardsToPlayerService.addCardsToPlayer(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(0)).save(player);
    }

    @Test
    void should_have_3_heroes_added() {
        List<HeroEntity> heroes = new ArrayList<>();
        heroes.add(new HeroEntity());
        heroes.add(new HeroEntity());
        heroes.add(new HeroEntity());
        PlayerEntity player = new PlayerEntity();

        addCardsToPlayerService.addCardsToPlayer(heroes, player);

        Mockito.verify(playerRepository, Mockito.times(1)).save(player);
        assert player.getDeck().getCards().size() == 3;
    }
}
