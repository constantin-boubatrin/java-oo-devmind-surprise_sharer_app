package main.shareSurprises;

public class GiveSurprisesAndHug extends AbstractGiveSurprises {

    GiveSurprisesAndHug(String containerType, int waitTime) {
        super(containerType, waitTime);
    }

    @Override
    protected void giveWithPassion() {
        System.out.println("Warm wishes and a big hug!");
    }
}