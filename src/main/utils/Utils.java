package main.utils;

import java.util.Random;

public final class Utils {
    // Random is used to generate a stream of pseudorandom numbers
    private static final Random random = new Random();

    // Returns a random integer number between [0, max]
    public static int genRandomInt(int max) {
        return random.nextInt(max);
    }
}