package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception;

public class PlayerNotCreatedException extends RuntimeException {
    private String simpleMessage;
    public PlayerNotCreatedException(String detailMessage, String debugMessage) {
        super(debugMessage);
        simpleMessage = detailMessage;
    }
    public String getSimpleMessage() {
        return simpleMessage;
    }
}