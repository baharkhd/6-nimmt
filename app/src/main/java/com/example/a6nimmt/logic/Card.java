package com.example.a6nimmt.logic;

import android.widget.ImageView;

public class Card {

    private int score;
    private int number;
    private ImageView cardImage;

    public Card() {

    }

    public Card(int score, int number) {
        this.score = score;
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
