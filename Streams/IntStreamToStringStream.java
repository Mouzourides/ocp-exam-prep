import java.util.stream.IntStream;
import java.util.stream.Stream;

class IntStreajR9StringStream {
    public static void main(String args[]) {
        IntStream ds = IntStream.of(1, 2, 2, 4);

        Stream<String> ste = ds.boxed().map((e) -> Integer.toString(e));
        System.out.println(ste.distinct().findFirst());
    }
}