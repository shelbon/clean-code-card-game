package com.groupe.cardgame.app.domain.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RarityTest {

    @Test
    public void testGetBonus() {
        Rarity common = Rarity.COMMON;
        assertEquals(0, common.getBonus());

        Rarity rare = Rarity.RARE;
        assertEquals(10, rare.getBonus());

        Rarity legendary = Rarity.LEGENDARY;
        assertEquals(20, legendary.getBonus());
    }

    @Test
    public void testGetLegendaryProbability() {
        Rarity legendary = Rarity.LEGENDARY;
        assertEquals(20, legendary.getLegendaryProbability());
    }

    @Test
    public void testGetRareProbability() {
        Rarity rare = Rarity.RARE;
        assertEquals(10, rare.getRareProbability());
    }

    @Test
    public void testGetCommonProbability() {
        Rarity common = Rarity.COMMON;
        assertEquals(0, common.getCommonProbability());
    }

}
