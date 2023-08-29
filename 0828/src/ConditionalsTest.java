import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConditionalsTest {

    @org.junit.jupiter.api.Test
    void computeGrade() {
        Assertions.assertEquals("A", Conditionals.computeGrade(95));
        Assertions.assertEquals("B", Conditionals.computeGrade(80));
        Assertions.assertEquals("C", Conditionals.computeGrade(79));
        Assertions.assertEquals("D", Conditionals.computeGrade(65));
        Assertions.assertEquals("F", Conditionals.computeGrade(32));
    }

    @Test
    void isStrictlyIncreasing() {
        Assertions.assertTrue(Conditionals.isStrictlyIncreasing(3, 4, 5));
        Assertions.assertFalse(Conditionals.isStrictlyIncreasing(3, 3, 5));
        Assertions.assertFalse(Conditionals.isStrictlyIncreasing(3, 2, 5));
        Assertions.assertFalse(Conditionals.isStrictlyIncreasing(3, 2, 1));
    }

    @Test
    void monthToDays() {
        Assertions.assertEquals(28, Conditionals.monthToDays("February"));
        Assertions.assertEquals(31, Conditionals.monthToDays("March"));
        Assertions.assertEquals(30, Conditionals.monthToDays("June"));
        Assertions.assertEquals(31, Conditionals.monthToDays("July"));
        Assertions.assertEquals(31, Conditionals.monthToDays("August"));
        Assertions.assertEquals(31, Conditionals.monthToDays("October"));
    }
}