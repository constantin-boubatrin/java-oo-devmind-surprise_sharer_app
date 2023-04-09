package main.storageSurprises;

import main.typesOfSurprises.ISurprise;
import main.utils.Utils;

/** The 'RandomBag' class defines the random distribution of surprises. */

public class RandomBag extends AbstractBag {
    @Override
    public ISurprise takeOut(){
        // Check if the surprise list is empty
        if (super.getSurpriseList().isEmpty()) return null;
        // Generates a random index
        int randomIndex = Utils.genRandomInt(getSurpriseList().size());
        // Copy random surprise
        ISurprise randomSurprise = super.getSurpriseList().get(randomIndex);
        // Remove random surprise from 'surpriseList'
        super.removeInSurpriseList(randomIndex);
        // Return the surprise
        return randomSurprise;
    }
}