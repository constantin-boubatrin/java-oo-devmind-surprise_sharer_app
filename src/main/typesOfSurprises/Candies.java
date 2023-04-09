package main.typesOfSurprises;

import main.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;

/** The 'Candies' class represents a surprise containing
  * a random number of candies of a certain type. */

public class Candies implements ISurprise {
    /** FIELDS */
    private static final int MAX_NUMBER_OF_CANDIES = 100; // class constant
    // Collection of candy types
    private static final ArrayList<String> CANDY_LIST = new ArrayList<>(
            Arrays.asList("chocolate", "jelly", "fruit", "vanilla", "bubble gum", "licorice"));
    private final int amount;
    private final String type;

    /** CONSTRUCTORS */
    Candies(int amount, String type) {
        // We will not leave any child without candy
        if (amount <= 0) {
            amount = 10;
        }
        this.amount = amount;
        this.type = type.toLowerCase();
    }

    /** METHODS */
    private int getAmount() {
        return this.amount;
    }

    private String getType() {
        return this.type;
    }

    public static Candies generate(){
        int randomAmount = Utils.genRandomInt(MAX_NUMBER_OF_CANDIES);
        int randomType = Utils.genRandomInt(CANDY_LIST.size());
        return new Candies(randomAmount, CANDY_LIST.get(randomType));
    }

    @Override
    public void enjoy() {
        System.out.printf("Enjoy your Candies!!!" +
                "\nYou received %d %s.%n", getAmount(), getAmount() == 1 ? getType() : getType() + "s");
    }

    @Override
    public String toString(){
        return "[Candies] | TYPE: " + getType() + " | AMOUNT: " + getAmount();
    }
}