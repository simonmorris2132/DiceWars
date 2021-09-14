/* This class creates a new player and keeps all data about the player (name, score) */


package com.company;

import java.util.ArrayList;

@SuppressWarnings("all")

public class Player implements Comparable<Player> {

    public ArrayList<Die> dice;
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int rollDice() {
        int totalRoll = 0;
        for (int i = 0; i < dice.size(); i++) {
            Die tempDie = dice.get(i);
            tempDie.rollDie();
            totalRoll += tempDie.getValue();
        }
        return totalRoll;
    }

    @Override
    public int compareTo(Player anotherScore) {
        return this.score - anotherScore.getScore();
    }
}