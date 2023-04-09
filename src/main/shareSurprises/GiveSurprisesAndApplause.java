package main.shareSurprises;

public class GiveSurprisesAndApplause extends AbstractGiveSurprises {

    GiveSurprisesAndApplause(String containerType, int waitTime) {
        super(containerType, waitTime);
    }

    @Override
    protected void giveWithPassion() {
        System.out.println("Loud applause to you... For it is in giving that we receive.");
    }
}