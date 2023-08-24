import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestingMethodsTest {

    @Test
    void fiToCm() {
        Assertions.assertEquals(205.74, TestingMethods.fiToCm(5, 21));
        Assertions.assertEquals(0, TestingMethods.fiToCm(0,0));
        Assertions.assertEquals(33.02, TestingMethods.fiToCm(0,13));
        Assertions.assertEquals(2164.08, TestingMethods.fiToCm(71,0));
    }

    @Test
    void combineDigits() {
        Assertions.assertEquals(42, TestingMethods.combineDigits(4, 2));
        Assertions.assertEquals(19, TestingMethods.combineDigits(1, 9));
        Assertions.assertEquals(0, TestingMethods.combineDigits(0, 0));
    }

    @Test
    void sumOfCubes() {
        Assertions.assertEquals(126, TestingMethods.sumOfCubes(5, 1));
        Assertions.assertEquals(91, TestingMethods.sumOfCubes(4, 3));
        Assertions.assertEquals(0, TestingMethods.sumOfCubes(0, 0));
    }
}