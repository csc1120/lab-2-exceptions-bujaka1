/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Main Driver class
 * Name: Alexander Bujak
 * Last Updated: 10/28/24
 */
package bujaka;

import java.util.Arrays;
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
        String n = scan.nextLine();
        String[] nums = n.split(" ");
        int[] list = new int[nums.length];
        for (int i = 0; i < list.length; i++){
            list[i] = Integer.parseInt(nums[i]);
        }
        return list;
    }

    private Die[] createDice(int numDice, int numSides){
        if (numDice >= MIN_DICE && numDice <= MAX_DICE) {
            Die[] dieList = new Die[numSides];
            for (int i = numDice; i > 0; i--) {
                dieList = new Die[] {new Die(numSides)};
            }
            return dieList;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] input = getInput();
        System.out.println(Arrays.toString(input));
    }
}