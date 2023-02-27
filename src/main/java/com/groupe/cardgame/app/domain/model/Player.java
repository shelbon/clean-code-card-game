package com.groupe.cardgame.app.domain.model;

import lombok.AllArgsConstructor;


public class Player {
    private String username;
    private int numberOfTokens;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void setNumberOfTokens(int numberOfTokens) {
        this.numberOfTokens = numberOfTokens;
    }

    public Player(String username, int numberOfTokens) {
        this.username = username;
        this.numberOfTokens = numberOfTokens;
    }
    public Player() {}
    public Player(String username) {
        this.username = username;
        this.numberOfTokens = 4;
    }
}