package com.example.a6nimmt.logic;

public class SelectedCard {

    private int playerNumber;
    private Card card;

    public SelectedCard(int playerNumber, Card card) {
        this.playerNumber = playerNumber;
        this.card = card;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}

