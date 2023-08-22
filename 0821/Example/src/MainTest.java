import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

// Once in here, "Assertions" and "Test" will be highlighted in red.
// Hover over "Assertions", and click "Add library JUnit 5.8.1 to classpath".
class MainTest {

    @org.junit.jupiter.api.Test
    void fahrenheitToCelsius() {
        // To write a test, we use the Assertions.assertEquals() method.
        // It has two parameters: an expected value and an actual value.
        // Expected is what we WANT the test to produce, whereas actual
        // is what it, well, actually resolves to!
        //
        // Your "actual" argument should be a call to your method.
        Assertions.assertEquals(0, Main.fahrenheitToCelsius(32));
        Assertions.assertEquals(37, Main.fahrenheitToCelsius(98.6));
        Assertions.assertEquals(100, Main.fahrenheitToCelsius(212));
        Assertions.assertEquals(-40, Main.fahrenheitToCelsius(-40));
    }
}