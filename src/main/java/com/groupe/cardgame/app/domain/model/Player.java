package com.groupe.cardgame.app.domain.model;

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
}
