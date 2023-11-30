import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ILinearSearchTest {

    private static final AbstractList<Integer> LS1 = new ArrayList<>(List.of(78, 43, 22, 101, 29, 34, 23, 12, 33));
    private static final AbstractList<Integer> LS2 = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12));
    private static final AbstractList<Integer> LS3 = new ArrayList<>(List.of(12,11,10,9,8,7,6,5,4,3,2,1));

    private static final AbstractList<Integer> LS4 = new ArrayList<>(List.of());

    @Test
    void testSrls() {
        ILinearSearch<Integer> ls = new StandardRecursiveLinearSearch<>();
        assertAll(
                () -> assertEquals(2, ls.linearSearch(LS1, 22)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS1, 102)),
                () -> assertEquals(8, ls.linearSearch(LS1, 33)),
                () -> assertEquals(0, ls.linearSearch(LS1, 78)),

                () -> assertEquals(2, ls.linearSearch(LS2, 3)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS2, 13)),
                () -> assertEquals(8, ls.linearSearch(LS2, 9)),
                () -> assertEquals(0, ls.linearSearch(LS2, 1)),

                () -> assertEquals(9, ls.linearSearch(LS3, 3)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS3, 13)),
                () -> assertEquals(3, ls.linearSearch(LS3, 9)),
                () -> assertEquals(11, ls.linearSearch(LS3, 1))
        );
    }

    @Test
    void testTrls() {
        ILinearSearch<Integer> ls = new TailRecursiveLinearSearch<>();
        assertAll(
                () -> assertEquals(2, ls.linearSearch(LS1, 22)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS1, 102)),
                () -> assertEquals(8, ls.linearSearch(LS1, 33)),
                () -> assertEquals(0, ls.linearSearch(LS1, 78)),

                () -> assertEquals(2, ls.linearSearch(LS2, 3)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS2, 13)),
                () -> assertEquals(8, ls.linearSearch(LS2, 9)),
                () -> assertEquals(0, ls.linearSearch(LS2, 1)),

                () -> assertEquals(9, ls.linearSearch(LS3, 3)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS3, 13)),
                () -> assertEquals(3, ls.linearSearch(LS3, 9)),
                () -> assertEquals(11, ls.linearSearch(LS3, 1))
        );
    }

    @Test
    void testLLs() {
        ILinearSearch<Integer> ls = new LoopLinearSearch<>();
        assertAll(
                () -> assertEquals(2, ls.linearSearch(LS1, 22)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS1, 102)),
                () -> assertEquals(8, ls.linearSearch(LS1, 33)),
                () -> assertEquals(0, ls.linearSearch(LS1, 78)),

                () -> assertEquals(2, ls.linearSearch(LS2, 3)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS2, 13)),
                () -> assertEquals(8, ls.linearSearch(LS2, 9)),
                () -> assertEquals(0, ls.linearSearch(LS2, 1)),

                () -> assertEquals(9, ls.linearSearch(LS3, 3)),
                () -> assertThrows(NoSuchElementException.class, () -> ls.linearSearch(LS3, 13)),
                () -> assertEquals(3, ls.linearSearch(LS3, 9)),
                () -> assertEquals(11, ls.linearSearch(LS3, 1))
        );
    }

}