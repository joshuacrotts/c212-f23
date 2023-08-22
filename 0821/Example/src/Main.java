
// To create tests for "fahrenheitToCelsius, right-click the class
// name, hit "show context actions", then "create test".
// If a dialog box pops up saying that no test roots were found, just
// hit okay.
//
// Hit the "fix" button if it appears in the next dialog box.
// Then, check the box beside "fahrenheitToCelsius".
public class Main {

    /**
     * Converts a temperature given in fahrenheit to celsius.
     * @param tf - temperature in fahrenheit
     * @return temperature in celsius
     */
    public static double fahrenheitToCelsius(double tf) {
        return (tf - 32.0) * (5.0 / 9.0);
    }
}
