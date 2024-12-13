/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * Die class
 * Name: Alexander Bujak
 * Last Updated: 10/21/24
 */
package bujaka;

import java.util.Random;

/**
 * The Die class will keep track of the number of sides on the Die,
 * which should be between 2-100 inclusive,
 * and whatever the current value of the top side of the Die is.
 * It will also use a Random object to determine the next value when the Die is "rolled".
 */
public class Die {

    /**
     * The minimum sides of a die, which is 2.
     */
    public static final int MIN_SIDES = 2;

    /**
     * The maximum sides of a die, which is 100
     */
    public static final int MAX_SIDES = 100;
    private int currentValue;
    private final int numSides;
    private final Random random = new Random();

    /**
     * Creates a Die object that has a number of sides
     * @param numSides The number of sides that the object has
     * @throws IllegalArgumentException Thrown when the parameter
     * doesn't fit the bounds of a regular die
     */
    public Die(int numSides) throws IllegalArgumentException{
        if (numSides < MIN_SIDES || numSides > MAX_SIDES){
            throw new IllegalArgumentException("Bad die creation: Illegal number of sides: "
                    + numSides);
        }
        this.numSides = numSides;
    }

    /**
     * Gets the current value that is rolled by the die
     * @return The current value of the die
     * @throws DieNotRolledException Thrown when the current value
     * doesn't fit the bounds of the number of sides of the die
     */
    public int getCurrentValue() throws DieNotRolledException{
        if (currentValue > numSides) {
            throw new DieNotRolledException();
        }
        int current = currentValue;
        currentValue = 0;
        return current;
    }

    /**
     * Creates a random integer and assigns it to the current value,
     * ensuring that the value is within the bounds of the number of sides
     */
    public void roll() {
        currentValue = random.nextInt(numSides) + 1;
    }
}