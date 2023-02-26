package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.PlayerNotCreatedException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.mapper.PlayerEntityMapper;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CreatePlayerService {
    private final PlayerRepository playerRepository;
    private final MessageSource messageSource;


    @Autowired
    public CreatePlayerService(PlayerRepository playerRepository, MessageSource messageSource, PlayerEntityMapper playerEntityMapper) {
        this.playerRepository = playerRepository;
        this.messageSource = messageSource;

    }

    public Optional<PlayerEntity> create(PlayerEntity playerEntity) {
        try {
            return Optional.of(playerRepository.save(playerEntity));
        } catch (Exception e) {
            throw new PlayerNotCreatedException(messageSource.getMessage("simple_create_player_error_message", null, Locale.getDefault()), e.getLocalizedMessage());
        }
    }
}