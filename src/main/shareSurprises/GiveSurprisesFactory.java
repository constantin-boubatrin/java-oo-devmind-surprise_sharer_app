package main.shareSurprises;

import main.utils.Utils;

public final class GiveSurprisesFactory {
    private static final int TYPES_OF_PASSION = 3;
    String containerType;
    int waitTime;

    public GiveSurprisesFactory(String bagType, int waitTime) {
        if (waitTime < 0) waitTime = 0;
        this.containerType = bagType.toUpperCase();
        this.waitTime = waitTime;
    }

    public IGiveSurprises giveSurprisesGenerator() {
        int randomPassion = Utils.genRandomInt(TYPES_OF_PASSION);
        return switch (randomPassion) {
            case 0 -> new GiveSurprisesAndApplause(this.containerType, this.waitTime);
            case 1 -> new GiveSurpriseAndSing(this.containerType, this.waitTime);
            case 2 -> new GiveSurprisesAndHug(this.containerType, this.waitTime);
            default -> throw new RuntimeException("ERROR: TYPES_OF_PASSION are not up to date.");
        };
    }
}