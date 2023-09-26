import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExamples {

    public static void main(String[] args) {
        // PriorityQueues are complicated, but let's say we want to insert
        // strings, and have strings that start with "p" be of a "higher priority"
        // than other strings.

        // We need to create a Comparator that defines this ordering.
        Comparator<String> c1 = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                // Make sure the strings are non-empty.
                if (!o1.isEmpty() && !o2.isEmpty()) {
                    // If they BOTH start with 'p', just compare the rest of their characters lexicographically.
                    if (o1.charAt(0) == 'p' && o2.charAt(0) == 'p') {
                        return o1.substring(1).compareTo(o2.substring(1));
                    } else if (o1.charAt(0) == 'p') {
                        // Give o1 higher priority by returning a negative number.
                        return -1;
                    } else if (o2.charAt(0) == 'p') {
                        // Give o2 higher priority by returning a positive number.
                        return 1;
                    }
                    // Otherwise, just compare them lexicographically.
                    else {
                        return o1.compareTo(o2);
                    }
                } else {
                    return 0;
                }
            }
        };

        // Now, we need to pass this Comparator object to a PriorityQueue.
        PriorityQueue<String> pq1 = new PriorityQueue<>(c1);
        pq1.add("pool");
        pq1.add("peek");
        pq1.add("hello");
        pq1.add("barks");
        pq1.add("park");
        pq1.add("pecking");
        pq1.add("shrub");

        System.out.println(pq1.poll()); // Highest priority (which is the lowest number) is "park".
        System.out.println(pq1.poll()); // Then pecking
        System.out.println(pq1.poll()); // Then peek
        System.out.println(pq1.poll()); // then pool (lexicographical!)
        System.out.println(pq1.poll()); // then barks
        System.out.println(pq1.poll()); // then hello
        System.out.println(pq1.poll()); // then shrub

        // We can also "inline" the comparator in the constructor as shown in class.
        PriorityQueue<String> pq2 = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Make sure the strings are non-empty.
                if (!o1.isEmpty() && !o2.isEmpty()) {
                    // If they BOTH start with 'p', just compare the rest of their characters lexicographically.
                    if (o1.charAt(0) == 'p' && o2.charAt(0) == 'p') {
                        return o1.substring(1).compareTo(o2.substring(1));
                    } else if (o1.charAt(0) == 'p') {
                        // Give o1 higher priority by returning a negative number.
                        return -1;
                    } else if (o2.charAt(0) == 'p') {
                        // Give o2 higher priority by returning a positive number.
                        return 1;
                    }
                    // Otherwise, just compare them lexicographically.
                    else {
                        return o1.compareTo(o2);
                    }
                } else {
                    return 0;
                }
            }
        });
    }
}
