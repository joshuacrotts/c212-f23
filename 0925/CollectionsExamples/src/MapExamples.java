import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExamples {

    public static void main(String[] args) {
        // Map is an interface:
        // Three classes/types of maps:
        // 1. HashMaps
        // 2. TreeMaps
        // 3. LinkedHashMaps

        // Use HashMaps when you don't care about the ordering of the keys.
        Map<String, Integer> m1 = new HashMap<>();
        m1.put("hello", 5);
        m1.put("hi", 2);
        m1.put("hey", 3);
        // We don't know nor do we really care about the ordering in which these
        // keys are entered into the map.
        System.out.println(m1.containsKey("hello")); // true
        System.out.println(m1.containsKey("heya")); // false
        System.out.println(m1.get("hi")); // returns the value associated with "hi", or null if not present.

        // To iterate over keys, use .keySet and the enhanced for loop.

        for (String k : m1.keySet()) {
            System.out.println(m1.get(k)); // Order? Who knows? We don't care!
        }

        System.out.println("------");

        // 2. TreeMaps
        // TreeMaps use the intrinsic/natural ordering of keys, OR a Comparator.
        // For Strings, that's lexicographical ordering.
        Map<String, Integer> m2 = new TreeMap<>();
        m2.put("hello", 5);
        m2.put("howdy", 2);
        m2.put("hiyaa", 3);

        for (String k : m2.keySet()) {
            System.out.println(m2.get(k)); // Outputs 5, 3, 2.
            // Why? "hiyaa" comes before "hello", which comes before "howdy".
        }

        System.out.println("------");

        // 3. LinkedHashMap
        // LinkedHashMaps use the INSERTION order of keys as the ordering in the map.
        Map<String, Integer> m3 = new LinkedHashMap<>();
        m3.put("hello", 5);
        m3.put("howdy", 2);
        m3.put("hiyaa", 3);

        for (String k : m3.keySet()) {
            System.out.println(m3.get(k)); // Outputs 5, 2, 3
            // Why? That's the order we inserted the pairs!
        }

    }
}
