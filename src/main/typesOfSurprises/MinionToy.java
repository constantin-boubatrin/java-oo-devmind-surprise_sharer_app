package main.typesOfSurprises;

import java.util.ArrayList;
import java.util.Arrays;

/** The 'MinionToy' class is a surprise that contains a minion. */

public class MinionToy implements ISurprise {
    /** FIELDS */
    private final String name;
    private static int nameIndex = 0;
    // Collection of minion names
    private static final ArrayList<String> MINION_NAME_LIST =
            new ArrayList<>(Arrays.asList("Dave", "Carl", "Kevin",
                    "Stuart", "Jerry", "Tim", "John", "Mark", "Mircea"));

    /** CONSTRUCTORS */
    MinionToy(String name) {
        this.name = name;
    }

    /** METHODS */
    private String getName() {
        return this.name;
    }

    public static MinionToy generate() {
        String name = MINION_NAME_LIST.get(nameIndex);
        MinionToy minionToy = new MinionToy(name);
        nameIndex++;
        if (nameIndex == MINION_NAME_LIST.size()) {
            nameIndex = 0;
        }
        return minionToy;
    }

    @Override
    public void enjoy() {
        System.out.printf("Enjoy your Minion Toy!!!" +
                "\nYou got a minion named %s.%n", getName());
    }

    @Override
    public String toString() {
        return "[Minion] | NAME: " + getName();
    }
}