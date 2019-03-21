import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;;

class CreatingStreams {
    public static void main(String args[]) {
        // Creating streams
        Stream emptyStream = Stream.empty();
        Stream stream1 = Stream.of(1, 2, 3);
        Stream stream2 = Stream.of(Arrays.asList(1, 2, 3));

        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream stream3 = list.stream();

        // Creating parallel streams
        Stream parallelStream = list.parallelStream();
        var parallelStream2 = stream1.parallel();

        // Create infinite streams
        Stream infiniteTwos = Stream.generate(() -> 2);
        Stream infiniteThrees = Stream.iterate(3, n -> n);
    }
}