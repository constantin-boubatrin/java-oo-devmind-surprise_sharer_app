package main.shareSurprises;

import main.createContainer.BagFactory;
import main.createContainer.IBagFactory;
import main.storageSurprises.IBag;
import main.typesOfSurprises.ISurprise;

import java.util.concurrent.TimeUnit;

/** The 'AbstractGiveSurprises' class details the surprise sharing mechanism,
  * using the previously implemented functionality. */

public abstract class AbstractGiveSurprises implements IGiveSurprises {
    /** FIELDS */
    private final IBagFactory iBagFactory;
    private final IBag container;
    private final int waitTime; // waiting time between dispensing surprises (surprise / seconds)

    /** CONSTRUCTORS */
    AbstractGiveSurprises(String containerType, int waitTime) {
        iBagFactory = new BagFactory();
        this.container = iBagFactory.makeBag(containerType);
        if(waitTime < 0) waitTime = 0;
        this.waitTime = waitTime;
    }

    /** METHODS */
    // Add a new surprise to the container
    @Override
    public void put(ISurprise newSurprise) {
        this.container.put(newSurprise);
    }

    // Moves all surprises from the parameter container to this container
    @Override
    public void put(IBag surprises) {
        this.container.put(surprises);
    }

    @Override
    public void putAfterGather(int number) {
        this.container.put(GatherSurprises.gather(number));
    }

    // Give a surprise
    // The order of distribution of surprises depends on the type of bag
    @Override
    public void give() {
        this.container.takeOut().enjoy();
        this.giveWithPassion();
        System.out.println();
    }

    // Give all the surprises
    @Override
    public void giveAll(){
        while (!container.isEmpty()) {
            this.give();
            // Sleep for X seconds - code snippet
            try {
                TimeUnit.SECONDS.sleep(10); // number of seconds to sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Check if the bag is empty
    @Override
    public boolean isEmpty() {
        return container.isEmpty();
    }

    //
    @Override
    public IBag getContainer() {
        return this.container;
    }

    protected abstract void giveWithPassion();
}