package main.storageSurprises;

import main.typesOfSurprises.ISurprise;

/** The "LIFOBag" class defines the distribution of surprises
  * according to the LIFO principle. */

public class LIFOBag extends AbstractBag {
    @Override
    public ISurprise takeOut() {
        // Check if the surprise list is empty
        if (super.getSurpriseList().isEmpty()) return null;
        // Copy last surprise IN
        ISurprise lastInSurprise = super.getSurpriseList().get(getSurpriseList().size() - 1);
        // Remove last surprise from 'surpriseList'
        super.removeInSurpriseList(getSurpriseList().size() - 1);
        // Return the surprise
        return lastInSurprise;
    }
}