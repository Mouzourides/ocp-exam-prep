import java.util.stream.*;

class PrimitiveStreams {
    public static void main(String... args) {
        // Primitive streams allow us to deal with primitives instead of wrapper classes
        // e.g. int primitive instead of Integer object

        IntStream intStream = IntStream.of(1, 2, 3);
        LongStream longStream = LongStream.of(1L, 2L, 3L);
        DoubleStream doubleStream = DoubleStream.of(1.0, 2.0, 3.0);

        // map object Integer to primitive int
        Stream<Integer> stream = Stream.of(1, 2, 3);
        IntStream intPrimitives = stream.mapToInt(num -> num);

        // map priitive stream to object Integer stream
        Stream<Integer> stream2 = intPrimitives.mapToObj(num -> num);
    }
}