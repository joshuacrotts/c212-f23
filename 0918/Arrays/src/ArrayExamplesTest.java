import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayExamplesTest {

    @org.junit.jupiter.api.Test
    void average() {
        assertAll(
                () -> assertEquals(70.4, ArrayExamples.average(new int[]{90, 80, 105, 50, 25}), 0.01),
                () -> assertEquals(0, ArrayExamples.average(new int[]{}), 0.01),
                () -> assertEquals(-55555.0, ArrayExamples.average(new int[]{-55555}), 0.01)
        );
    }

    @org.junit.jupiter.api.Test
    void longestRun() {
        assertAll(
                () -> assertArrayEquals(new int[]{6, 4}, ArrayExamples.longestRun(new int[]{9, 5, 4, 4, 4, 3, 3, 2, 6, 6, 6, 6, 11, 12, 11, 11, 11, 21, 12, 11})),
                () -> assertArrayEquals(new int[]{12, 12}, ArrayExamples.longestRun(new int[]{12,12,12,12,12,12,12,12,12,12,12,12})),
                () -> assertArrayEquals(new int[]{212, 1}, ArrayExamples.longestRun(new int[]{212, 343, 211, 200, 101, 436, 438, 311})),
                () -> assertArrayEquals(new int[]{211, 2}, ArrayExamples.longestRun(new int[]{212, 343, 211, 211, 101, 212, 212, 311}))

        );
    }
}