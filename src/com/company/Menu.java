/* This class is used to operate the menus. This works in conjunction with the CLI class to show the players the main, sub, and scoreboard menus. */

package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.company.CLI.flavorText;

@SuppressWarnings("all")

public class Menu {

    private static ArrayList<String> diceQuotes = new ArrayList<>();
    private static List<Player> scoreboard = new ArrayList<>();

    public static void start() {
        System.out.println("Welcome to Dice Wars!");
        mainMenu();
    }


    public static void mainMenu() {
        scoreboard();
        System.out.println("Would you like to start a new Dice-War? Y/N?");
        String input = CLI.getString(1,4);
        if (input.substring(0, 1).equalsIgnoreCase("Y")){
            flavorText("How many players will there be? Min of 2 players.");
            int players = CLI.getInt(2,10);
            System.out.println();

            flavorText("Ok! How many rounds do you want to play? Min of 1 round, max of 10.");
            int rounds = CLI.getInt(1,10);
            System.out.println();


            flavorText("Almost done! How many dice will each player roll per round? Min of 1, max of 10.\n");
            int diceAmount = CLI.getInt(1,10);
            System.out.println();

            System.out.println("Ok, lets review!\nNumber of players: " + players + "\nNumber of Rounds: " + rounds + "\nType of dice your rolling: D" + "\nThe amount of D" + " : " + diceAmount); //TODO: Refactor this code into a new method
            System.out.println("Is this all correct?\n Y to start the game or N to return to restart the form.");
            //TODO: Refactor this input code into a new method
            CLI.scanner.nextLine();
            String answer = CLI.getString(1, 3);
            if (answer.substring(0, 1).equalsIgnoreCase("Y")){
                flavorText("Excellent! Lets get rolling!!!");
                scoreboard.clear();
                new Game(players, rounds, diceAmount);
            }
            else if (answer.substring(0, 1).equalsIgnoreCase("N")){
                flavorText("Ok! Restarting the form...");
                //add method once code has been refactored
            }

        }

        else if(input.substring(0,1).equalsIgnoreCase("N")){
            CLI.exit();
        }

        else if (input.equalsIgnoreCase("test")){
            new Game(2,3, 4);
        }

    }

    private static void subMenu(int players, int rounds, int diceAmount) {
        System.out.println("Ok, lets review!\nNumber of players: " + players + "\nNumber of Rounds: " + rounds + "\nThe amount of " + diceAmount);
        System.out.println("Is this all correct?\n Y to start the game or N to return to restart the form.");
        CLI.scanner.nextLine();
        String answer = CLI.getString(1, 3);
        if (answer.substring(0, 1).equalsIgnoreCase("Y")) {
            flavorText("Excellent! Lets get rolling!!!");
            scoreboard.clear();
            new Game(players, rounds, diceAmount);
        } else if (answer.substring(0, 1).equalsIgnoreCase("N")) {
            flavorText("Ok! Restarting the form...");
            //add method once code has been refactored
        }
    }

    public static void scoreboard() {
        if (scoreboard.size() != 0) {
            System.out.println("Here is the scoreboard from our previous game!");
            Collections.sort(scoreboard);
            Collections.reverse(scoreboard);
            for (int i = 0; i < scoreboard.size(); i++) {
                System.out.println((i + 1) + ") " + scoreboard.get(i).getName() + "....." + scoreboard.get(i).getScore() + " Points");
            }
        }
    }


    public static List<Player> getScoreboard() {
        return scoreboard;
    }
}