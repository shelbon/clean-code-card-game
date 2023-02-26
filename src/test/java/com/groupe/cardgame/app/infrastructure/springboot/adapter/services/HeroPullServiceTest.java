package com.groupe.cardgame.app.infrastructure.springboot.adapter.services;

import com.groupe.cardgame.app.CardPackFactory;
import com.groupe.cardgame.app.HeroFactory;
import com.groupe.cardgame.app.domain.model.Rarity;
import com.groupe.cardgame.app.infrastructure.springboot.adapter.out.CardPackRepository;
import com.groupe.cardgame.app.infrastructure.springboot.models.HeroEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HeroPullServiceTest {
    @InjectMocks
    private com.groupe.cardgame.app.infrastructure.springboot.adapter.services.HeroPullService cardPullService;

    @Mock
    private static CardPackRepository cardPackRepository;
    private static CardPackFactory cardAndPackFactory;

    @BeforeAll
    static void setUp() {
        cardAndPackFactory = new CardPackFactory(new HeroFactory());
    }

    @Test
    void pullXTimes_when_number_card_per_pull_is_3_and_x_is_3_return_9_cards() {
        var returnedCardPack = cardAndPackFactory.generateCardPack();
        when(cardPackRepository.findById(returnedCardPack.getId())).thenReturn(Optional.of(returnedCardPack));
        var cardPack = cardPackRepository.findById(returnedCardPack.getId());
        assertThat(cardPack).isPresent();
        java.util.List<HeroEntity> pulledCard = cardPullService.pullXTimes(cardPack.get(), 3);
        assertThat(pulledCard).hasSize(9);
    }

    @Test
    void pull_on_card_pack_with_5_percent_legendary_get_at_least_one_in_100_try() {
        var returnedCardPack = cardAndPackFactory.generateCardPack();
        when(cardPackRepository.findById(returnedCardPack.getId())).thenReturn(Optional.of(returnedCardPack));
        var cardPack = cardPackRepository.findById(returnedCardPack.getId());
        assertThat(cardPack).isPresent();
        java.util.List<HeroEntity> pulledCard = cardPullService.pullXTimes(cardPack.get(), 100);
        int countOfSearchedRarity = pulledCard.stream().reduce(0, (total, hero) -> {
            if (hero.getRarity().getName()
                    .equals(Rarity.LEGENDARY.toString())) {
                total += 1;
            }
            return total;
        }, Integer::sum);
        assertThat(pulledCard).hasSize(300);
        assertThat(countOfSearchedRarity).isPositive();

    }

    @Test
    void pull_on_card_pack_with_20_percent_rare_get_at_least_ten_in_100_try() {
        var returnedCardPack = cardAndPackFactory.generateCardPack();
        when(cardPackRepository.findById(returnedCardPack.getId())).thenReturn(Optional.of(returnedCardPack));
        var cardPack = cardPackRepository.findById(returnedCardPack.getId());
        assertThat(cardPack).isPresent();
        java.util.List<HeroEntity> pulledCard = cardPullService.pullXTimes(cardPack.get(), 100);
        int countOfSearchedRarity = pulledCard.stream().reduce(0, (total, hero) -> {
            if (hero.getRarity().getName()
                    .equals(Rarity.RARE.toString())) {
                return total += 1;
            }
            return total;
        }, Integer::sum);

        assertThat(pulledCard.size()).isNotZero();
        assertThat(countOfSearchedRarity).isGreaterThanOrEqualTo(10);

    }

    @Test
    void pull_on_card_pack_with_75_percent_commong_get_at_least_50_in_100_try() {
        var returnedCardPack = cardAndPackFactory.generateCardPack();
        when(cardPackRepository.findById(returnedCardPack.getId())).thenReturn(Optional.of(returnedCardPack));
        var cardPack = cardPackRepository.findById(returnedCardPack.getId());
        assertThat(cardPack).isPresent();
        java.util.List<HeroEntity> pulledCard = cardPullService.pullXTimes(cardPack.get(), 100);
        int countOfSearchedRarity = pulledCard.stream().reduce(0, (total, hero) -> {
            if (hero.getRarity().getName()
                    .equals(Rarity.COMMON.toString())) {
                return total += 1;
            }
            return total;
        }, Integer::sum);
        assertThat(pulledCard.size()).isNotZero();
        assertThat(countOfSearchedRarity).isGreaterThanOrEqualTo(50);

    }
}