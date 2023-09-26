import java.util.*;

public class SetExamples {

    public static void main(String[] args) {
        // Set is an interface:
        // Sets do not contain duplicates.
        // Three classes/types of sets:
        // 1. HashSet
        // 2. TreeSet
        // 3. LinkedHashSet

        // Use HashSets when you don't care about the ordering of the values.
        Set<Integer> s1 = new HashSet<>();
        s1.add(57);
        s1.add(42);
        s1.add(101);
        s1.add(28);
        s1.add(19);

        // We don't know nor do we really care about the ordering in which these
        // values are entered into the set.
        System.out.println(s1.contains(42)); // true
        System.out.println(s1.contains(43)); // false
        System.out.println(s1.remove(19)); // removes 19 if it exists, which it does. returns true if it was removed

        // To iterate over values, use the enhanced for loop.

        for (int v : s1) {
            System.out.println(v); // Order? Who knows? We don't care!
        }

        System.out.println("------");

        // 2. TreeSet
        // TreeSet use the intrinsic/natural ordering of values, OR a Comparator.
        // For Integers, that's the numeric ordering
        Set<Integer> s2 = new TreeSet<>();
        s2.add(57);
        s2.add(42);
        s2.add(101);
        s2.add(28);
        s2.add(19);

        for (int v : s2) {
            System.out.println(v); // Order: [19, 28, 42, 57, 101]
        }

        System.out.println("------");

        // 3. LinkedHashSet
        // LinkedHashSets use the INSERTION order of values as the ordering in the set.
        Set<Integer> s3 = new LinkedHashSet<>();
        s3.add(57);
        s3.add(42);
        s3.add(101);
        s3.add(28);
        s3.add(19);

        for (int v : s3) {
            System.out.println(v); // Outputs 57, 42, 101, 28, 19
            // Why? That's the order we inserted the values!
        }
    }
}
