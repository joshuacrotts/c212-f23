import java.util.LinkedList;
import java.util.Queue;

public class QueueExamples {

    public static void main(String[] args) {
        // Queues are kind of dumb in Java; we can't directly instantiate one
        // since there is no Queue class; only an interface.
        // We need to use LinkedLists.

        Queue<Integer> q = new LinkedList<>();

        q.add(57);
        q.add(101);
        q.add(27);

        // Queues are first-in-first-out; think of a queue at a theme park
        // (excluding any "fast pass" bs).

        System.out.println(q.peek()); // Returns the element at the front of the queue; 57
        System.out.println(q.poll()); // Returns and removes the front of the queue; 57.
        System.out.println(q.peek()); // Front is now 101.
    }
}
