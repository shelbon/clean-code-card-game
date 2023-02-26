package com.groupe.cardgame.app.application.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.AddHeroesToPlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.models.DeckEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddHeroesToPlayerServiceTest {

    @InjectMocks
    private AddHeroesToPlayerService addHeroesToPlayerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    void should_add_heroes_to_player_deck() {
        // Given
        PlayerEntity player = new PlayerEntity(1L, "test player", new DeckEntity());
        List<HeroEntity> heroes = new ArrayList<>();
        HeroEntity hero1 = new HeroEntity(1L, "test hero 1", 100, 50, 20, 1, null, null);
        HeroEntity hero2 = new HeroEntity(2L, "test hero 2", 150, 80, 10, 1, null, null);
        heroes.add(hero1);
        heroes.add(hero2);

        when(playerRepository.save(player)).thenReturn(player);

        // When
        addHeroesToPlayerService.addCardsToPlayerDeck(heroes, player);

        // Then
        verify(playerRepository, times(1)).save(player);
        assertEquals(2, player.getDeck().getCards().size());
    }

    @Test
    void should_not_add_heroes_to_player_when_heroes_is_null() {
        PlayerEntity player = new PlayerEntity(1L, "test player", new DeckEntity());

        assertThrows(IllegalArgumentException.class, () -> addHeroesToPlayerService.addCardsToPlayerDeck(null, player));
        verifyNoInteractions(playerRepository);
    }

    @Test
    void should_not_add_heroes_to_player_deck_when_player_is_null() {
        // Given
        List<HeroEntity> heroes = new ArrayList<>();
        HeroEntity hero1 = new HeroEntity(1L, "test hero 1", 100, 50, 20, 1, null, null);
        HeroEntity hero2 = new HeroEntity(2L, "test hero 2", 150, 80, 10, 1, null, null);
        heroes.add(hero1);
        heroes.add(hero2);

        // When/Then
        assertThrows(IllegalArgumentException.class, () -> addHeroesToPlayerService.addCardsToPlayerDeck(heroes, null));
        verifyNoInteractions(playerRepository);
    }
}
