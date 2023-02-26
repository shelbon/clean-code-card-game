package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.application.port.in.CreatePlayerQuery;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreatePlayerServiceTest {
    @InjectMocks
    private CreatePlayerService createPlayerService;
    @Mock
    private PlayerRepository playerRepository;
    @Captor
    private ArgumentCaptor<PlayerEntity> playerEntityArgumentCaptor;


    @Test
    void can_create_player_with_valid_username() {
        var createPlayerQuery = new CreatePlayerQuery("bob");
        var newPlayer = new PlayerEntity(createPlayerQuery.username());
        when(playerRepository.save(any(PlayerEntity.class))).thenReturn(newPlayer);
        var createdPlayer = createPlayerService.create(newPlayer);

        verify(playerRepository).save(playerEntityArgumentCaptor.capture());
        verifyNoMoreInteractions(playerRepository);

        assertThat(playerEntityArgumentCaptor.getValue()).isEqualTo(newPlayer);
        assertThat(createdPlayer)
                .isPresent()
                .contains(newPlayer);
    }
}