/* This class is where all the mechanics of the game lie. every other class is used in this class to make the game work. */


package com.company;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<>();
    private int numOfRounds;
    private int numOfDice;
    private ArrayList<Player> winner = new ArrayList<>();
    private Die dice;

    public Game(int numOfPlayers, int numOfRounds, int numOfDice) {
        generatePlayers(numOfPlayers);
        this.numOfRounds = numOfRounds;
        this.numOfDice = numOfDice;
    }

    public void startGame() {
        CLI.flavorText("Welcome to Dice-Wars!");

        for (int i = 1; i <= numOfRounds; i++) {
            CLI.flavorText("Round " + i + "!");

            for (Player player : players) {
                playerTurn(player);
            }
            printScore(i);
        }
    }

    private void playerTurn(Player player) {

        int roundScore = 0;

        System.out.println("It is " + player.getName() + "'s turn! Roll your damn die.");
        String enter = CLI.getString(0, 1);

        if (CLI.scanner.hasNextLine()) {
            enter = CLI.scanner.nextLine();
        }

        if (enter.equals("")) {
            for (int i = 1; i <= numOfDice; i++) {
                dice.rollDie();
                System.out.println("Dice " + i + " rolled a " + dice.getValue() + "!");
                roundScore += dice.getValue();
            }
            player.setScore(player.getScore() + roundScore);
            CLI.flavorText(player.getName() + " rolled a total of " + roundScore + " for this round!");
        }
    }

    public void printScore(int roundNum) {

        int highestScore = 0;
        System.out.println("Total scores for this round: " + roundNum + "!\n");

        for (Player player : players) {
            System.out.println(player.getName() + " has a total of " + player.getScore() + "!\n");

            if (player.getScore() >= highestScore) {
                highestScore = player.getScore();
            }
        }

        for (Player scores : players) {
            if (roundNum != numOfRounds && highestScore == scores.getScore()) {
                System.out.println("\n" + scores.getName() + " is in the lead with " + scores.getScore() + " points!\n");
        }

            if (roundNum == numOfRounds && highestScore == scores.getScore()) {
                winner.add(scores);

                if (winner.size() > 1) ;
                {
                    System.out.println("We have " + winner.size() + " winner(s)! Congrats to");
                    for (Player winner : winner) {
                        System.out.println(winner.getName() + " with " + winner.getScore() + " points!");
                    }
                }
                CLI.flavorText("\nAnd our winner is " + scores.getName() + " with " + scores.getScore() + " points! Congrats!\n");
                for (Player players : players) {
                    Menu.getScoreboard().add(players);
                }
                Menu.mainMenu();
            }
        }

    }

    private void generatePlayers(int numOfPlayers) {
        players.clear();
        for (int i = 0; i < numOfPlayers; i++) {
            System.out.println("Enter your name!");
            String name = CLI.getString();
            Player newPlayer = new Player(name);
            players.add(newPlayer);
        }
        startGame();
    }


    private ArrayList<Die> generateDie() {
        ArrayList<Die> tempArr = new ArrayList<Die>();

        for (int i = 0; i < numOfDice; i++) {
            Die newDie = new Die(6);
            tempArr.add(newDie);
        }
        return tempArr;
    }
}



