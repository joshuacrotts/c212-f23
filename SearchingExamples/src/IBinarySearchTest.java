import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IBinarySearchTest {

    private static final AbstractList<Integer> LS1 = new ArrayList<>(List.of(12, 22, 23, 29, 33, 34, 43, 78, 101));
    private static final AbstractList<Integer> LS2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12));
    @Test
    void testTrbs() {
        IBinarySearch<Integer> ls = new TailRecursiveBinarySearch<>();
        assertAll(
                () -> assertEquals(1, ls.binarySearch(LS1, 22)),
                () -> assertEquals(-1, ls.binarySearch(LS1, 102)),
                () -> assertEquals(4, ls.binarySearch(LS1, 33)),
                () -> assertEquals(7, ls.binarySearch(LS1, 78)),

                () -> assertEquals(2, ls.binarySearch(LS2, 3)),
                () -> assertEquals(-1, ls.binarySearch(LS2, 13)),
                () -> assertEquals(8, ls.binarySearch(LS2, 9)),
                () -> assertEquals(0, ls.binarySearch(LS2, 1))
        );
    }

    @Test
    void testLbs() {
        IBinarySearch<Integer> ls = new LoopBinarySearch<>();
        assertAll(
                () -> assertEquals(1, ls.binarySearch(LS1, 22)),
                () -> assertEquals(-1, ls.binarySearch(LS1, 102)),
                () -> assertEquals(4, ls.binarySearch(LS1, 33)),
                () -> assertEquals(7, ls.binarySearch(LS1, 78)),

                () -> assertEquals(2, ls.binarySearch(LS2, 3)),
                () -> assertEquals(-1, ls.binarySearch(LS2, 13)),
                () -> assertEquals(8, ls.binarySearch(LS2, 9)),
                () -> assertEquals(0, ls.binarySearch(LS2, 1))
        );
    }
}