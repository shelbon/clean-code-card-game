package com.groupe.cardgame.app.application.port.in;

import com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception.PullHeroesException;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PullHeroesQuery {

    private Long userId;
    @NotBlank
    private long packId;
    @Min(1)
    private int numberOfPulls;

    public PullHeroesQuery(Long userId, int packId, int tokenConsumed, int numberOfPulls) {
        if (numberOfPulls < 1) {
            throw new PullHeroesException("Number of pulls must be greater than zero");
        }
        this.userId = userId;
        this.packId = packId;
        this.numberOfPulls = numberOfPulls;
    }

    public Long userId() {
        return userId;
    }

    public  long packId() {
        return packId;
    }

    public int numberOfPulls() {
        return numberOfPulls;
    }
}