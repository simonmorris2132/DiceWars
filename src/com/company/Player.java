/* This class creates a new player and keeps all data about the player (name, score) */


package com.company;

public class Player implements Comparable<Player> {

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

    @Override
    public int compareTo(Player anotherScore) {
        return this.score - anotherScore.getScore();
    }
}