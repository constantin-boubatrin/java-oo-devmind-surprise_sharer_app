package main.createContainer;

import main.storageSurprises.IBag;

/** The common interface for creating containers.*/

public interface IBagFactory {
    // Create a new container, according to the specified type
    IBag makeBag(String type);
}