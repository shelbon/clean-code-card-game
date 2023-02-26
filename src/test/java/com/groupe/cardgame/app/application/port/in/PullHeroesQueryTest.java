package com.groupe.cardgame.app.application.port.in;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.PullHeroesException;
import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PullHeroesQueryTest {

    @Test
    void shouldCreateValidQuery() {
        PullHeroesQuery pullHeroesQuery = new PullHeroesQuery(1L, 1, 1, 1);
        assertEquals(1L, pullHeroesQuery.userId());
        assertEquals(1, pullHeroesQuery.packId());
        assertEquals(1, pullHeroesQuery.numberOfPulls());
    }

    @Test
    void shouldThrowExceptionWhenNumberOfPullsIsLessThanOne() {
        assertThrows(PullHeroesException.class, () -> new PullHeroesQuery(1L, 1, 1, 0));
    }
}
