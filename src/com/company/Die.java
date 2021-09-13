/* This class creates a die of sorts. This basically is just an object used in the game class. */


package com.company;

public class Die {

    private final int sides;
    private int value;

    public Die(int sides) {
        this.sides = sides;
        this.value = getValue();
    }

    public void rollDie() {
        value = (int) (Math.random() * sides + 1);
    }
    public int getValue() {
        return value;
    }
}
