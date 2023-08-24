public class TestingMethods {


    /**
     * Converts an amount in feet and inches into centimeters.
     * @param double feet
     * @param double inches
     *
     * @return double amount in centimeters
     */
    public static double fiToCm(double feet, double inches) {
        final double IN_TO_CM = 2.54;
        final double FT_TO_IN = 12;
        return ((feet * FT_TO_IN) + inches) * IN_TO_CM;
    }

    /**
     * Receives two single-digit integers and combines them.
     *
     * @param int first digit.
     * @param int second digit.
     *
     * @return the combined digits.
     */
    public static int combineDigits(int tens, int ones) {
        return tens * 10 + ones;
    }

    /**
     * Receives two numbers and computes the sum of their cubes.
     *
     * @param double first number
     * @param double second number
     *
     * @return double sum of cubes
     */
    public static double sumOfCubes(double a, double b) {
//        return a * a * a + b * b * b;
        return Math.pow(a, 3) + Math.pow(b, 3);
    }
}
