public class Fibonacci {

    static int fibonacciTR(int n) {
        return fibonacciTRHelper(n, 0, 1);
    }

    static int fibonacciWhile(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) {
            return a;
        } else {
            while (!(n == 1)) {
                int ta = a;
                a = b;
                b = ta + b;
                n--;
            }
            return b;
        }
    }

    static int factorialFor(int n) {
        int a = 0;
        int b = 1;
        if (n == 0) {
            return a;
        } else {
            for (int i = n; i >= 2; i--) {
                int ta = a;
                a = b;
                b = ta + b;
            }
            return b;
        }
    }

    /**
     * fib(6) = 8
     * fibonacciTRHelper(6, 0, 1)
     * fibonacciTRHelper(5, 1, 1)
     * fibonacciTRHelper(4, 1, 2)
     * fibonacciTRHelper(3, 2, 3)
     * fibonacciTRHelper(2, 3, 5)
     * fibonacciTRHelper(1, 5, 8)
     *
     * @param n
     * @return
     */
    private static int fibonacciTRHelper(int n, int a, int b) {
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else {
            return fibonacciTRHelper(n - 1, b, a + b);
        }
    }

    public static void main(String[] args) {
        int i = 0;
        while (i <= 10) {
            System.out.println(i * 10);
            i++;
        }
        for (int j = 0; j <= 10; j++) {
            System.out.println(j * 10);
        }
    }
}
