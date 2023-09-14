import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTRTester {

    @Test
    void problem1Test() {
        Assertions.assertEquals(1, Fibonacci.fibonacciTR(1));
    }

    @Test
    void problem2Test() {
        Assertions.assertEquals(21, Fibonacci.fibonacciTR(8));
    }

    @Test
    void problem3Test() {
        Assertions.assertEquals(1597, Fibonacci.fibonacciTR(17));
    }

}
