package com.groupe.cardgame.app.infra.springboot.adapter.in.exception;

public class ResourceNotFoundException extends RuntimeException {
    private String simpleMessage;

    public ResourceNotFoundException(String detailMessage, String debugMessage) {
        super(debugMessage);
        this.simpleMessage = detailMessage;
    }

    public String getSimpleMessage() {
        return simpleMessage;
    }
}