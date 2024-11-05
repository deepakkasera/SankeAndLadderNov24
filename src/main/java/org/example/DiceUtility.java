package org.example;

public class DiceUtility {
    public static int roll() {
        int min = 1;
        int max = 6;

        return (int) Math.floor(Math.random() * (max - min + 1) + min);

        //TODO:
        //Modify the above function to return a random value based on the number of dices.
    }
}