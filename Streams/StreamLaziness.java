import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLaziness {
    public static void main(String args[]) {

        // Lazy, only prints two values because two print statements
        Stream<String> stream = Stream.of("A", "B", "C", "D");
        System.out.println(stream.peek(System.out::print).findAny().orElse("NA"));

        // Lazy but prints all because all values are needed to collect to a list
        Stream<String> stream2 = Stream.of("A", "B", "C", "D");
        System.out.println(stream2.peek(System.out::print).collect(Collectors.toList()));
    }
}
