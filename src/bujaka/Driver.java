/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Alexander Bujak
 * Last Updated: 12/13/24
 */
package bujaka;

import java.util.Scanner;

/**
 * Contains a number of helper methods along with the main() method.
 */
public class Driver {
    /**
     * The minimum number of dice, which is 2.
     */
    public static final int MIN_DICE = 2;

    /**
     * The maximum number of dice, which is 10.
     */
    public static final int MAX_DICE = 10;

    private static int[] getInput() {
        Scanner scan = new Scanner(System.in);
        boolean checker = false;
        int[] list = new int[0];
        while (!checker) {
            System.out.print("""
                    Please enter the number of dice to roll, how many sides the dice have,
                    and how many rolls to complete, separating the values by a space.
                    Example: "2 6 1000"
                    
                    Enter Configuration:""");
            try {
                String n = scan.nextLine();
                String[] nums = n.split(" ");
                list = new int[nums.length];
                for (int i = 0; i < list.length; i++) {
                    list[i] = Integer.parseInt(nums[i]);
                }
                checker = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input: All values must be whole numbers.");
            }
            if (list.length != 3) {
                System.out.println("Invalid input: Expected 3 values but only received "
                        + list.length);
                checker = false;
            }
        }
        return list;
    }

    private static Die[] createDice(int numDice, int numSides){
        if (numDice >= MIN_DICE && numDice <= MAX_DICE) {
            Die[] dieList = new Die[numDice];
            try {
                for (int i = 0; i < numDice; i++) {
                    dieList[i] = new Die(numSides);
                }
            } catch (IllegalArgumentException e){
                return dieList;
            }
            return dieList;
        } else {
            return null;
        }
    }

    private static int[] rollDice(Die[] dice, int numSides, int numRolls){
        int[] rolls = new int[(numSides * dice.length) - dice.length + 1];
        Die d = new Die(numSides);
        for (int i = 0; i < rolls.length; i++){
            int total = 0;
            for (int j = 0; j <= numRolls; j++){
                int roll = 0;
                for (int k = 0; k < dice.length; k++) {
                    d.roll();
                    roll += d.getCurrentValue();
                }
                if (roll == i + dice.length) {
                    total++;
                }
            }
            rolls[i] = total;
        }
        return rolls;
    }

    private static int findMax(int[] rolls){
        int max = 0;
        for (int roll : rolls) {
            if (roll > max) {
                max = roll;
            }
        }
        return max;
    }

    private static void report(int numDice, int[] rolls, int max){
        final int s = 10;
        int scale = max / s;
        for (int i = 0; i < rolls.length; i++){
            int numStars = rolls[i] / scale;
            System.out.printf("%-2d:%-8d", i + numDice, rolls[i]);
            for(int j = 0; j < numStars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        boolean checker = false;
        int[] input = new int[0];
        Die[] dice = new Die[0];
        int[] results = new int[0];
        while (!checker) {
            try {
                input = getInput();
                if (input.length == 3) {
                    dice = createDice(input[0], input[1]);
                }
                assert dice != null;
                results = rollDice(dice, input[1], input[2]);
                checker = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Bad die creation: Illegal number of sides: " + input[1]);
            }
        }
        int max = findMax(results);
        report(input[0], results, max);
    }
    /*boolean checker = false;
        int[] input = new int[0];
        Die[] dice = new Die[0];
        while (!checker) {
            System.out.print("""
                     Please enter the number of dice to roll, how many sides the dice have,
                     and how many rolls to complete, separating the values by a space.
                     Example: "2 6 1000"

                     Enter Configuration:""");
            try {
                input = getInput();
                if (input.length == 3) {
                    dice = createDice(input[0], input[1]);
                    checker = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Bad die creation: Illegal number of sides: " + input[1]);
            }
        }
        int[] results;
        if (dice != null) {
            results = rollDice(dice, input[1], input[2]);
            int max = findMax(results);
            report(input[0], results, max);
        }
    }
    */
}