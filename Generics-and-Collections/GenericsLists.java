import java.util.Arrays;
import java.util.List;

class GenericsLists {
    public static void main(String[] args) {
        List<? extends Object> list = Arrays.asList(new Double(1), new Integer(10));

        // Compile error, can't add to list due to list type not property being defined
        // list.add(new Double(1));
        // list.add(new Integer(10));

        System.out.println(list);
    }
}
