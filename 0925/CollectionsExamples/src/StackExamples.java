import java.util.LinkedList;
import java.util.Stack;

public class StackExamples {

    public static void main(String[] args) {
        // To create a Stack, use the following:
        Stack<Integer> s1 = new Stack<>();
        // Stacks use push, pop, and peek. Also isEmpty...

        // Think of a stack like a stack of plates; you can't remove
        // plates from anywhere but the top or else the entire stack collapses.
        // You can only insert plates from the top of the stack. Same principle!

        s1.push(57);
        s1.push(101);
        s1.push(27);

        // Stacks are "last-in-first-out", i.e., the last thing entered is the first
        // thing to be removed or peeked.
        // Peek returns, but does NOT remove, the top of the stack.
        System.out.println(s1.peek()); // 27

        // Pop returns AND removes the top of the stack.
        System.out.println(s1.pop()); // 27
        System.out.println(s1.peek()); // 101

        // We can simulate stacks using linkedlists!
        // addLast, removeLast...
        // getLast
        // But if we do this, we may as well just use the Stack class.
        LinkedList<Integer> ls1 = new LinkedList<>();
        ls1.addLast(57);
        ls1.addLast(101);
        ls1.addLast(27);

        System.out.println(ls1.getLast()); // 27
        System.out.println(ls1.removeLast()); // 27
        System.out.println(ls1.getLast()); // 101

    }
}
