public class Conditional {

    /**
     * Determines if an integer is even.
     *
     * @param int integer to check.
     *
     * @return whether the int is even.
     */
    public static boolean isEven(int n) {
//      return n % 2 == 0;
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
