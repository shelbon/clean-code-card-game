package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception;

public class PullHeroesException extends RuntimeException  {
    public PullHeroesException(String message) {
        super(message);
    }
}