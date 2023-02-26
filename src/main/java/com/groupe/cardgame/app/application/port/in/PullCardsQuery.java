package com.groupe.cardgame.app.application.port.in;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PullCardsQuery {

    private Long userId;
    @NotBlank
    private long packId;
    @Min(1)
    private int tokenConsumed;
    @Min(1)
    private int numberOfPulls;

    public PullCardsQuery(Long userId, int packId, int tokenConsumed, int numberOfPulls) {
        this.userId = userId;
        this.packId = packId;
        this.tokenConsumed = tokenConsumed;
        this.numberOfPulls = numberOfPulls;
    }

    public Long userId() {
        return userId;
    }

    public  long packId() {
        return packId;
    }

    public int tokenConsumed() {
        return tokenConsumed;
    }

    public int numberOfPulls() {
        return numberOfPulls;
    }
}