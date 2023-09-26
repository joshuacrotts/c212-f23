import java.util.LinkedList;
import java.util.List;

public class LinkedListExamples {

    public static void main(String[] args) {
        // To create a Linked List, use the following syntax:
        LinkedList<Integer> ls1 = new LinkedList<>();

        // Methods: same as ArrayList; get, add, insert, set, remove...

        // Recall the problem with ArrayLists--removing or inserting from anywhere
        // except the rear is costly! LinkedLists do not have this problem.
        ls1.add(57);
        ls1.add(101);
        ls1.add(24);
        ls1.add(67);
        ls1.add(2);
        ls1.add(9);

        // Retrieving an element using an "index" is slow.
        System.out.println(ls1.get(3)); // 67
        // Removing elements from the front or rear is instantaneous!
        // - Why? No shifting!
        ls1.removeFirst();
        System.out.println(ls1.toString()); // [101, 24, 67, 2, 9]
        ls1.removeLast();
        System.out.println(ls1.toString()); // [101, 24, 67, 2]

        // Removing from the middle just readjusts the "links".
        ls1.remove(2);
        System.out.println(ls1.toString()); // [101, 24, 2]
    }
}
