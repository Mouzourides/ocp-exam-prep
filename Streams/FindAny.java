import java.nio.file.*;
import java.util.regex.*;
import java.util.stream.*;

class FindAny {
    public static void main(String args []) {
            Stream<String> stream = Stream.of("ABC", "ABCD");
            String out = stream.findAny().orElse("None");
            System.out.println(out);
    }
}