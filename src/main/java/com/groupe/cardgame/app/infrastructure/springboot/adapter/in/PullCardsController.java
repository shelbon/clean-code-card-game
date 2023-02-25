package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.PullCardsQuery;
import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.CardPackEmptyException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.ResourceNotFoundException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.AddCardsToPlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.CardPackRepository;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.CardPullService;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Optional;

@RestController

public class PullCardsController {
    private final CardPullService cardPullService;
    private final CardPackRepository cardPackRepository;
   private final AddCardsToPlayerService addCardsToPlayerService;
    @Autowired
    MessageSource messageSource;
    final private PlayerRepository playerRepository;

    public PullCardsController(CardPullService cardPullService, CardPackRepository cardPackRepository, AddCardsToPlayerService addCardsToPlayerService, PlayerRepository playerRepository) {
        this.cardPullService = cardPullService;
        this.cardPackRepository = cardPackRepository;
        this.addCardsToPlayerService = addCardsToPlayerService;
        this.playerRepository = playerRepository;
    }

    @PostMapping("/cards")
    public ApiResponse pullCards(@RequestBody PullCardsQuery pullCardsQuery, Locale locale) {
        ApiResponse apiResponse;
        Optional<CardPackEntity> cardPack = cardPackRepository
                .findById(pullCardsQuery.packId());
       var user=playerRepository.findById(pullCardsQuery.userId());
       if(user.isEmpty()){
           throw new IllegalArgumentException("some input is not valid");
       }
        java.util.List<CardEntity> cards = new ArrayList<>();
        cardPack.ifPresentOrElse(pack -> {
            if (pack.getCards().isEmpty()) {
                throw new CardPackEmptyException("Card pack is empty");
            }
            cards.addAll(cardPullService.pullXTimes(pack, pullCardsQuery.numberOfPulls()));
        },() -> {
            var message =messageSource.getMessage("debug_not_found",null,locale);
            var debugMessage =messageSource.getMessage("simple_not_found_message",null,locale);
          throw new ResourceNotFoundException(message,debugMessage);
        });
        addCardsToPlayerService.addCardsToPlayer(cards,user.get());
        apiResponse = new ApiResponseWithBody<>(HttpStatus.OK, cards);

        return apiResponse;
    }
}