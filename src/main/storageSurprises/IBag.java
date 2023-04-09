package main.storageSurprises;

import main.typesOfSurprises.ISurprise;
import java.util.ArrayList;
import java.util.Arrays;

public interface IBag {
    // Collection of bag types
    ArrayList<String> TYPES_OF_BAGS =
            new ArrayList<>(Arrays.asList("RANDOM", "FIFO", "LIFO"));

    // adds a surprise in the bag
    void put(ISurprise newSurprise);

    // adds all the surprises from another IBag
    //   -> the 'bagOfSurprises' will be empty() afterwards
    void put(IBag bagOfSurprises);

    // adds an Array of surprises in the bag
    void put(ArrayList<ISurprise> newSurpriseList);

    // removes a surprise from the bag and returns it
    ISurprise takeOut();

    // Checks if the bag is empty or not
    boolean isEmpty();

    // Returns the number of surprises
    int size();

    // print surprises from list
    void printSurpriseList();
}