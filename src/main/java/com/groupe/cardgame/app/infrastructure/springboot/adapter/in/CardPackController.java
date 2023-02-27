package com.groupe.cardgame.app.infrastructure.springboot.adapter.in;

import com.groupe.cardgame.app.application.port.in.CardPackFillRandomQuery;
import com.groupe.cardgame.app.application.response.ApiResponse;
import com.groupe.cardgame.app.application.response.ApiResponseWithBody;
import com.groupe.cardgame.app.domain.model.HeroFactory;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.ResourceNotFoundException;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.CardPackRepository;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.HeroRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.CardPackEntity;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/card-pack")
public class CardPackController {
    private final CardPackRepository cardPackRepository;

    private final HeroEntityMapper heroEntityMapper;
    private final MessageSource messageSource;

    public CardPackController(CardPackRepository cardPackRepository, HeroRepository heroRepository, HeroEntityMapper heroEntityMapper, MessageSource messageSource) {
        this.cardPackRepository = cardPackRepository;
        this.heroEntityMapper = heroEntityMapper;


        this.messageSource = messageSource;
    }

    @PostMapping("/fill-random")
    public ApiResponse fillCardPack(@Valid @RequestBody CardPackFillRandomQuery cardPackFillRandomQuery, Locale locale) {
        var cardPack = cardPackRepository.findById(cardPackFillRandomQuery.cardPackId());
        AtomicReference<CardPackEntity> savedCardPack = new AtomicReference<>();
        ApiResponse apiResponse;
        cardPack.ifPresentOrElse(cardPack1 -> {
            cardPack1.addCards(HeroFactory.createRandomHeroes(cardPackFillRandomQuery.numberOfCard()).stream()
                    .map(heroEntityMapper::toEntity)
                    .toList());
            savedCardPack.set(cardPackRepository.save(cardPack1));
        }, () -> {
            var message = messageSource.getMessage("debug_not_found", null, locale);
            var debugMessage = messageSource.getMessage("simple_not_found_message", null, locale);
            throw new ResourceNotFoundException(message, debugMessage);
        });
        apiResponse = new ApiResponseWithBody<CardPackEntity>(HttpStatus.OK, savedCardPack.get());
        return apiResponse;

    }

}