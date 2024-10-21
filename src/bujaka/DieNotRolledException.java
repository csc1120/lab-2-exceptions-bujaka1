/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Alexander Bujak
 * Last Updated: 10/21/24
 */
package bujaka;

/**
 * An exception that would be used whenever the current value of the dice
 * doesn't fit within the boundaries of the number of sides of the dice.
 */
public class DieNotRolledException extends RuntimeException {
    @Override
    public String getMessage(){
        return "Dice wasn't rolled";
    }
}
