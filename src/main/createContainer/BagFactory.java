package main.createContainer;

import main.storageSurprises.IBag;
import main.storageSurprises.FIFOBag;
import main.storageSurprises.LIFOBag;
import main.storageSurprises.RandomBag;

public class BagFactory implements IBagFactory {
    @Override
    public IBag makeBag(String type) {
        type = type.toUpperCase();
        int index = IBag.TYPES_OF_BAGS.indexOf(type);

        return switch (index) {
            case 0 -> new RandomBag();
            case 1 -> new FIFOBag();
            case 2 -> new LIFOBag();
            default -> throw new RuntimeException(type + " is unknown type.");
        };
    }
}