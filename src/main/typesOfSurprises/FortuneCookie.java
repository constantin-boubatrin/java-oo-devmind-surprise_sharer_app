package main.typesOfSurprises;

import main.utils.Utils;
import java.util.ArrayList;
import java.util.Arrays;

/** The 'FortuneCookie' class represents a surprise in which the person
  * will receive a symbolic message to guide them in the future. */

public class FortuneCookie implements ISurprise{
    /** FIELDS */
    private final String message;
    // Vector of sayings
    private static final ArrayList<String> SAYING_LIST = new ArrayList<>(Arrays.asList(
            "The fortune you seek is in another cookie, Austrian Johannes Gierlinger",
            "A closed mouth gathers no feet",
            "A conclusion is simply the place where you got tired of thinking",
            "A cynic is only a frustrated optimist",
            "A foolish man listens to his heart. A wise man listens to cookies",
            "You will die alone and poorly dressed",
            "A fanatic is one who can't change his mind, and won't change the subject",
            "If you look back, you’ll soon be going that way",
            "You will live long enough to open many fortune cookies",
            "An alien of some sort will be appearing to you shortly",
            "Do not mistake temptation for opportunity",
            "Flattery will go far tonight",
            "He who laughs at himself never runs out of things to laugh at",
            "He who laughs last is laughing at you",
            "He who throws dirt is losing ground",
            "Some men dream of fortunes, others dream of cookies",
            "The greatest danger could be your stupidity",
            "We don’t know the future, but here’s a cookie",
            "The world may be your oyster, but it doesn't mean you'll get its pearl",
            "You will be hungry again in one hour"));

    /** CONSTRUCTORS */
    FortuneCookie(String message) {
        this.message = message;
    }

    /** METHODS */
    private String getMessage() {
        return this.message;
    }

    public static FortuneCookie generate() {
        int noRandom = Utils.genRandomInt(SAYING_LIST.size());
        return new FortuneCookie(SAYING_LIST.get(noRandom));
    }

    @Override
    public void enjoy() {
        System.out.printf("You got a Fortune Cookie!!!" +
                "\nThe saying is \"%s\".%n", getMessage());
    }

    @Override
    public String toString() {
        return "[FortuneCookie] | MESSAGE: " + getMessage();
    }
}