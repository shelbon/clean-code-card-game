package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.port.in.PullHeroesQuery;
import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.CardPackEmptyException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.PullHeroesException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.ResourceNotFoundException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.CardPackRepository;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.services.AddHeroesToPlayerDeckService;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.services.HeroPullService;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@RestController

public class PullHeroesController {
    private final HeroPullService heroPullService;
    private final CardPackRepository cardPackRepository;
    private final AddHeroesToPlayerDeckService addCardsToPlayerService;

    private final MessageSource messageSource;
    private final PlayerRepository playerRepository;

    public PullHeroesController(HeroPullService heroPullService, CardPackRepository cardPackRepository, AddHeroesToPlayerDeckService addCardsToPlayerService, MessageSource messageSource, PlayerRepository playerRepository) {
        this.heroPullService = heroPullService;
        this.cardPackRepository = cardPackRepository;
        this.addCardsToPlayerService = addCardsToPlayerService;
        this.messageSource = messageSource;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/cards")
    public ApiResponse pullCards(@RequestBody PullHeroesQuery pullHeroesQuery, Locale locale) {
        ApiResponse apiResponse;
        Optional<CardPackEntity> cardPack = cardPackRepository
                .findById(pullHeroesQuery.packId());
        var user = playerRepository.findById(pullHeroesQuery.userId());
        if (user.isEmpty()) {
            throw new IllegalArgumentException("some input is not valid");
        }
        java.util.List<HeroEntity> cards = new ArrayList<>();
        cardPack.ifPresentOrElse(pack -> {
            if (pack.getCards().isEmpty()) {
                throw new CardPackEmptyException("Card pack is empty");
            }
            cards.addAll(heroPullService.pullXTimes(pack, pullHeroesQuery.numberOfPulls()));

        }, () -> {
            var message = messageSource.getMessage("debug_not_found", null, locale);
            var debugMessage = messageSource.getMessage("simple_not_found_message", null, locale);
            throw new ResourceNotFoundException(message, debugMessage);
        });
        addCardsToPlayerService.addHeroesToPlayerDeck(cards, user.get());

        apiResponse = new ApiResponseWithBody<>(HttpStatus.OK, cards);

        return apiResponse;
    }
}