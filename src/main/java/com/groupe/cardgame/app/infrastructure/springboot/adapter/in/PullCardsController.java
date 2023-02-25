package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.PullCardsQuery;
import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.CardPackEmptyException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.ResourceNotFoundException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.AddHeroesToPlayerService;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.CardPackRepository;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.HeroPullService;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.PlayerRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackEntity;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
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
    private final HeroPullService cardPullService;
    private final CardPackRepository cardPackRepository;
   private final AddHeroesToPlayerService addHeroesToPlayerService;
    @Autowired
    MessageSource messageSource;
    final private PlayerRepository playerRepository;

    public PullCardsController(HeroPullService cardPullService, CardPackRepository cardPackRepository, AddHeroesToPlayerService addHeroesToPlayerService , PlayerRepository playerRepository) {
        this.cardPullService = cardPullService;
        this.cardPackRepository = cardPackRepository;
        this.addHeroesToPlayerService = addHeroesToPlayerService;
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
        java.util.List<HeroEntity> cards = new ArrayList<>();
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
        addHeroesToPlayerService.addCardsToPlayer(cards,user.get());
        apiResponse = new ApiResponseWithBody<>(HttpStatus.OK, cards);

        return apiResponse;
    }
}