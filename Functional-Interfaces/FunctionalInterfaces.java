import java.util.function.*;

class FunctionalInterfaces {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hi there";
        String s = supplier.get();
        System.out.println(s); // Hi there

        Consumer<String> consumer = (String name) -> System.out.println(name);
        consumer.accept("Nik"); // Nik

        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + ", " + b);
        biConsumer.accept("1", "2"); // 1, 2

        Function<Integer, String> function = (num) -> num.toString();
        String f = function.apply(10);
        System.out.println(f); // 10

        BiFunction<Integer, Integer, String> biFunction = (a, b) -> a + ", " + b;
        String bf = biFunction.apply(1, 2);
        System.out.println("BiFunction: " + bf); // 1, 2

        UnaryOperator<Integer> unaryOperator = (num) -> ++num;
        int u = unaryOperator.apply(10);
        System.out.println(u); // 11

        BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        int bo = binaryOperator.apply(1, 2);
        System.out.println(bo); // 3

        Predicate<Integer> predicate = (num) -> num > 10;
        boolean p = predicate.test(11);
        System.out.println(p); // true

        BiPredicate<Integer, Integer> biPredicate = (a, b) -> (a + b) > 10;
        boolean bp = biPredicate.test(1, 2);
        System.out.println(bp); // false
    }
}