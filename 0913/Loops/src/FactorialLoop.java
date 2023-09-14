public class FactorialLoop {

    static int factLoop(int n) {
        int acc = 1;
        while (!(n == 0)) {
            acc = acc * n;
            n--;
        }
        return acc;
    }

    static int factForLoop(int n) {
        int acc = 1;
        for (int i = 2; i <= n; i++) {
            acc *= i;
        }
        return acc;
    }

    static int factTR(int n) {
        return factTRHelper(n, 1);
    }

    private static int factTRHelper(int n, int acc) {
        if (n == 0) return acc;
        else return factTRHelper(n - 1, acc * n);
    }



















//    static int factLoop(int n) {
//        int acc = 1;
//        while (!(n == 0)) {
//            acc = acc * n;
//            n = n - 1;
//        }
//        return acc;
//    }
//
//    // This works, but what about a "for" loop?
//    // For loops are used for "determinate" loop conditions.
//    // While loops are used for "indeterminate" loop conditions.
//    // Creates a local variable that serves as the counter.
//    // No need to modify the input parameter.
//    static int factForLoop(int n) {
//        int acc = 1;
//        // Three components:
//        // Initializer, condition, step.
//        for (int i = 1; i <= n; i++) {
//            acc = acc * i;
//        }
//        return acc;
//    }
}