import java.util.*;

class MapReplaceAll {
    public static void main(String args[]) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("ab", 1);
        map.put("abc", 2);
        map.put("abcd", 3);

        map.replaceAll((k, v) -> (int) k.charAt(v));

        System.out.println(map);
    }
}