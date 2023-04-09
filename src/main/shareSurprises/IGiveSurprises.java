package main.shareSurprises;

import main.storageSurprises.IBag;
import main.typesOfSurprises.ISurprise;

public interface IGiveSurprises {
    // adds a surprise in the bag
    void put(ISurprise newSurprise);

    // adds all the surprises from another IBag
    //   -> the 'newBag' will be empty() afterwards
    void put(IBag newBag);

    // adds an Array of surprise in the bag with capacity == number
    void putAfterGather(int number);

    // Returns the container
    IBag getContainer();

    //Gives a surprise from bag.
    void give();

    //Gives all surprises from bag.
    void giveAll();

    // Checks if the bag is empty or not
    boolean isEmpty();
}