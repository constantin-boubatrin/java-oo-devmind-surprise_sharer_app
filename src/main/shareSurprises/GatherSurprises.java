package main.shareSurprises;

import main.typesOfSurprises.Candies;
import main.typesOfSurprises.FortuneCookie;
import main.typesOfSurprises.ISurprise;
import main.typesOfSurprises.MinionToy;
import main.utils.Utils;

import java.util.ArrayList;

/** The class 'GatherSurprises' through the methods gather(), gather(int n) details
  * the actual action of collecting the surprises prepared by generous people for
  * the little ones (i.e. around the holidays).
  * Since each person prepares what surprise they want, the collection / surprise
  * returned will be different every time. */

public final class GatherSurprises { // "final" prevents class extension
    /** FIELDS */
    private static final int TYPES_OF_SURPRISES = 3; // class constance

    /** CONSTRUCTORS */
    private GatherSurprises() { // "private" prevents class instantiation
    }

    /** METHODS */
    // Return a single 'ISurprise'
    public static ISurprise gather() {
        int randomType = Utils.genRandomInt(TYPES_OF_SURPRISES);
        return switch (randomType) {
            case 0 -> FortuneCookie.generate();
            case 1 -> Candies.generate();
            case 2 -> MinionToy.generate();
            default -> throw new RuntimeException("ERROR: 'TYPES_OF_SURPRISES' are not up to date.");
        };
    }

    // Return a collection of n 'ISurprise'
    public static ArrayList<ISurprise> gather(int n) {
        if(n < 0) n = 0;

        ArrayList<ISurprise> surpriseList = new ArrayList<>(n);
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                surpriseList.add(gather());
            }
        }
        return surpriseList;
    }
}