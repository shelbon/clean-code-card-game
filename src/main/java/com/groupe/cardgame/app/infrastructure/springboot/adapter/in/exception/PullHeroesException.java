package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception;

public class PullHeroesException extends RuntimeException {
    private String message;
    public PullHeroesException(String message) {
        super(message);
    }

    public String getMessage() {
        return message;
    }
}