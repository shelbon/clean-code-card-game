package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;


import com.groupe.cardgame.app.application.port.in.CreatePlayerQuery;
import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.mapper.PlayerEntityMapper;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.services.CreatePlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.models.PlayerEntity;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final CreatePlayerService createPlayerService;
    private final MessageSource messageSource;
    private final PlayerEntityMapper playerEntityMapper;

    public PlayerController(CreatePlayerService createPlayerService, MessageSource messageSource, PlayerEntityMapper playerEntityMapper) {
        this.createPlayerService = createPlayerService;
        this.messageSource = messageSource;
        this.playerEntityMapper = playerEntityMapper;
    }

    @PostMapping({"/", ""})
    public ApiResponse createPlayer(@Valid @RequestBody CreatePlayerQuery createPlayerQuery) {
        PlayerEntity playerEntity = playerEntityMapper
                .toEntity(createPlayerQuery);
        Optional<PlayerEntity> savedPlayerEntity = createPlayerService
                .create(playerEntity);
        AtomicReference<ApiResponse> apiResponse =
                new AtomicReference<>();
        savedPlayerEntity.ifPresent(savedEntity -> {
            apiResponse.set(new ApiResponseWithBody<>(HttpStatus.CREATED,
                    playerEntityMapper
                            .fromEntityToSimplePlayerInfo(savedEntity)));
        });
        return apiResponse.get();
    }
}