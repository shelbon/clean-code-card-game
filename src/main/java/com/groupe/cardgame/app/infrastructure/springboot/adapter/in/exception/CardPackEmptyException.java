package com.groupe.cardgame.app.infrastructure.springboot.adapter.in.exception;

public class CardPackEmptyException  extends RuntimeException {
    public CardPackEmptyException(String message) {
        super(message);
    }
}