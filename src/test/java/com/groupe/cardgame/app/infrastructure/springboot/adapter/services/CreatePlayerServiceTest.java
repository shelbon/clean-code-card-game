package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.application.port.in.CreatePlayerQuery;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.DTO.SimplePlayerInfo;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
    private ArgumentCaptor<String> usernameCaptor;


    @Test
    void can_create_player_with_valid_username() {
        var username = "bob";
        var createPlayerQuery = new CreatePlayerQuery(username);
        var newPlayer = new SimplePlayerInfo(0L, username);
        when(playerRepository.save(any(String.class))).thenReturn(Optional.of(newPlayer));
        var createdPlayer = createPlayerService.create(createPlayerQuery);

        verify(playerRepository).save(usernameCaptor.capture());
        verifyNoMoreInteractions(playerRepository);

        assertThat(usernameCaptor.getValue()).isEqualTo(username);
        assertThat(createdPlayer).isPresent();
        assertThat(createdPlayer.get()).isEqualTo(newPlayer);
    }
}