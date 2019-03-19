
import java.util.Arrays;
import java.util.stream.Stream;

class EnumExample {

    void printFuturamaCharacters() {
        // Values method returns an array of the enum type
        // Ordinal method prints corresponding int
        Arrays.stream(FuturamaCharacters.values()).forEach((FuturamaCharacters c) -> {
            System.out.println(c.name() + ", " + c.ordinal());
        });
    }

    public static void main(String args[]) {
        EnumExample e = new EnumExample();
        e.printFuturamaCharacters();

        FuturamaCharacters bender = FuturamaCharacters.BENDER;
        if (bender == FuturamaCharacters.BENDER); // returns true

        // ENUMS AREN'T INTS
        // if (FuturamaCharacters.BENDER == 0) {...} -- This does not compile

        // Can be created from strings, although it is case sensitive
        FuturamaCharacters zoidberg = FuturamaCharacters.valueOf("ZOIDBERG"); // works!
        // FuturamaCharacters incorrectZoidberg = FuturamaCharacters.valueOf("zoidberg");
        // ^ throws IllegalArgumentException

        // You also can't extend Enums e.g.
        // class MattGroeningCharacters extends FuturamaCharacters { ... } -- doesn't
        // compile

        FuturamaCharacters.ZOIDBERG.quote();

        // Custom bye
        FuturamaCharacters.BENDER.sayBye();
        // Default bye
        FuturamaCharacters.ZOIDBERG.sayBye();
    }
}