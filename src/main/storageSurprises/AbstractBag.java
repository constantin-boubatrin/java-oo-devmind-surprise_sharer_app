package main.storageSurprises;

import main.typesOfSurprises.ISurprise;
import java.util.ArrayList;

abstract class AbstractBag implements IBag {
    private ArrayList<ISurprise> surpriseList = new ArrayList<>();

    public ArrayList<ISurprise> getSurpriseList() {
        return this.surpriseList;
    }

    public void removeInSurpriseList(int index) {
        this.getSurpriseList().remove(index);
    }

    @Override
    public void put(ISurprise newSurprise) {
        this.surpriseList.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while (!bagOfSurprises.isEmpty()) {
            put(bagOfSurprises.takeOut());
        }
    }

    @Override
    public void put(ArrayList<ISurprise> newSurpriseList) {
        for (ISurprise iSurprise: newSurpriseList) {
            put(iSurprise);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.surpriseList.isEmpty();
    }

    @Override
    public int size() {
        return this.surpriseList.size();
    }

    @Override
    public void printSurpriseList() {
        if (this.surpriseList == null || isEmpty()) {
            System.out.println("The bag is empty!!!");

        } else {
            System.out.println("Bag surprises are: ");
            for (ISurprise iSurprise: this.surpriseList) {
                System.out.println(iSurprise);
            }
        }
    }
}