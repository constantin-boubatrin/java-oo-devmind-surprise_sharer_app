package test;

import main.createContainer.BagFactory;
import main.storageSurprises.IBag;
import main.createContainer.IBagFactory;
import main.shareSurprises.GiveSurprisesFactory;
import main.shareSurprises.IGiveSurprises;
import main.shareSurprises.GatherSurprises;
import java.util.Scanner;

/**
 * The main class for the Surprise Sharer Application (Console-OO, non-graphics version)
 */

public class SurpriseSharerApp {
    private static final Scanner in = new Scanner(System.in);

    private void run() {
        // Let's crate a 'GiveSurprise' Object that will contain Bag of Surprises (first Bag)
        String bagType;
        int waitTime;
        do {
            System.out.println("Let's create a 'GiveSurprise' Object that will contain Bag of Surprises.");
            System.out.println("What type of bag do you want (RANDOM, FIFO, LIFO) ?");
            bagType = in.nextLine().toUpperCase();
            System.out.println("How long do you want to wait between each surprise given (in s) ?");
            waitTime = in.nextInt();
            in.nextLine();

        } while (!IBag.TYPES_OF_BAGS.contains(bagType));

        // Test 'GiveSurpriseFactory' Class
        // Create a 'GiveSurpriseFactory' based on user Input
        GiveSurprisesFactory giveSurprisesFactory = new GiveSurprisesFactory(bagType, waitTime);

        // Test 'IGiveSurprises' Class
        // Create an Object of type 'IGiveSurprises'
        IGiveSurprises iGiveSurprises = giveSurprisesFactory.giveSurprisesGenerator();

        // Gather n surprises...
        System.out.println("How many surprises do you want to gather?");
        iGiveSurprises.putAfterGather(in.nextInt());
        in.nextLine();
        System.out.println();

        // Let's print container contents:
        iGiveSurprises.getContainer().printSurpriseList();
        System.out.println();

        // Let's create a Bag of Surprises: (second bag)
        IBagFactory iBagFactory = new BagFactory();
        IBag iBag; // second bag

        do {
            System.out.println("Let's create another Bag of Surprises!");
            System.out.println("What type of bag do you want (RANDOM, FIFO, LIFO) ?");
            bagType = in.nextLine().toUpperCase();

        } while (!IBag.TYPES_OF_BAGS.contains(bagType));

        iBag = iBagFactory.makeBag(bagType);

        System.out.println("Let's add a random surprise to this bag...");
        iBag.put(GatherSurprises.gather());
        iBag.printSurpriseList();
        System.out.println();

        System.out.println("Let's add 6 more random surprises to this bag...");
        iBag.put(GatherSurprises.gather(6));
        iBag.printSurpriseList();
        System.out.println();

        // Let's try to add surprises from the second bag to the first bag
        String oneOrAll;
        do {
            System.out.println("How many surprises do you want to add from " +
                    "the second bag to the first bag, ONE or ALL:");
            oneOrAll = in.nextLine().toUpperCase();
        } while (!oneOrAll.equals("ONE") && !oneOrAll.equals("ALL"));

        System.out.println();

        if (oneOrAll.equals("ONE")) {
            iGiveSurprises.put(iBag.takeOut());
        } else if (oneOrAll.equals("ALL")) {
            iGiveSurprises.put(iBag);
        }

        // Let's print container contents
        System.out.println("'iGiveSurprises' Bag status: (first bag)");
        iGiveSurprises.getContainer().printSurpriseList();
        System.out.println();

        System.out.println("'iBag' Bag status: (second bag)");
        iBag.printSurpriseList();
        System.out.println();

        // Give One surprise or give All surprises ?
        System.out.println("Let's go back to the original 'iGiveSurprises' Object:");
        while (!iGiveSurprises.getContainer().isEmpty()) {
            System.out.println("Do you want to give one surprise or all surprises (type ONE or ALL)?");
            String userInput = in.nextLine().toUpperCase();

            if (userInput.equals("ONE")) {
                iGiveSurprises.give();
            } else if (userInput.equals("ALL")) {
                iGiveSurprises.giveAll();
            } else {
                System.err.println("Input Error");
            }
        }

        // Print the first bag
        System.out.println("First bag");
        iGiveSurprises.getContainer().printSurpriseList();
    }

    /**
     * DRIVER CODE
     */
    public static void main(String[] args) {
        // create and run an instance (for test purpose)
        new SurpriseSharerApp().run();
    }
}