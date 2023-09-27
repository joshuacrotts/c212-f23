import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class PostfixExpressionParser {

    /**
     * Parses an ArrayList of tokens for a postfixed expression.
     * @param tokens - numbers or arithmetic operators.
     * @return result of parsing expression.
     */
    static double postfixExpressionParser(ArrayList<String> tokens) {
        return 0;
    }

    /**
     * Evaluates a list of operands with a given operator, assuming left-associativity.
     *
     * @param rator - operator, either '+', '-', '*', or '/'.
     * @param rands - operands, a list of numbers.
     * @return result of applying operator to operands.
     */
    private static double eval(char rator, LinkedList<Double> rands) {
        assert !rands.isEmpty();
        double res = rands.poll();
        for (double v : rands) {
            switch (rator) {
                case '+' -> res += v;
                case '-' -> res -= v;
                case '*' -> res *= v;
                case '/' -> res /= v;
                default -> throw new IllegalArgumentException("eval: invalid operator " + rator);
            }
        }
        return res;
    }

    private static boolean isNumber(String v) {
        try {
            Double.parseDouble(v);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Testing eval:
        Stack<Double> ls1 = new Stack<>();
        ls1.push(5.0);
        ls1.push(12.0);
        ls1.push(44.0);
        ls1.push(2.0);

        // Why can't we use a stack for the list of operands...? The stupid iterator is broken.
        System.out.println(ls1);
        for(double v : ls1) {
            System.out.println(v);
        }
    }
}
