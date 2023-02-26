package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardPackRateTest {

    @Test
    public void testEquals() {
        CardPackRate rate1 = new CardPackRate(Rarity.COMMON, 0.75);
        CardPackRate rate2 = new CardPackRate(Rarity.COMMON, 0.75);
        CardPackRate rate3 = new CardPackRate(Rarity.RARE, 0.20);

        assertEquals(rate1, rate2); // reflexive
        assertEquals(rate2, rate1); // symmetric
        assertNotEquals(rate1, rate3); // different rarity
        assertNotEquals(rate1, null); // not equal to null
    }
}
