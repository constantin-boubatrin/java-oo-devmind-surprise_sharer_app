package main.storageSurprises;

import main.typesOfSurprises.ISurprise;

/** The "FIFOBag" class defines the distribution of surprises
  * according to the FIFO principle. */

public class FIFOBag extends AbstractBag {
    @Override
    public ISurprise takeOut() {
        // Check if the surprise list is empty
        if (super.getSurpriseList().isEmpty()) return null;
        // Copy first surprise IN
        ISurprise firstInSurprise = super.getSurpriseList().get(0);
        // Remove first surprise from 'surpriseList'
        super.removeInSurpriseList(0);
        // Return the surprise
        return firstInSurprise;
    }
}