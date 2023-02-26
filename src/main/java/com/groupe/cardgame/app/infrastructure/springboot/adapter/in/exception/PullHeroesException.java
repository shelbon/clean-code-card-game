package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception;

public class PullHeroesException extends RuntimeException {
    private String simpleMessage;
    public PullHeroesException(String detailMessage, String debugMessage) {
        super(debugMessage);
        simpleMessage = detailMessage;
    }
    public String getSimpleMessage() {
        return simpleMessage;
    }

    public String getMessage() {
        return simpleMessage;
    }
}