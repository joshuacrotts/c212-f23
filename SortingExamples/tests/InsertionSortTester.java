import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTester {

    private final AbstractList<Integer> LS1 = new ArrayList<>(List.of(5, 4, 2, 1, 3));
    private final AbstractList<Integer> LS2 = new ArrayList<>(List.of());
    private final AbstractList<Integer> LS3 = new ArrayList<>(List.of(10, 8, 6, 7, 2, 10, 3, 3, 3, 10));

    @Test
    void fInsSort() {
        IInsertionSort<Integer> ss = new FunctionalInsertionSort<>();
        assertAll(
                () -> assertEquals(List.of(1, 2, 3, 4, 5), ss.insertionSort(LS1)),
                () -> assertEquals(List.of(), ss.insertionSort(LS2)),
                () -> assertEquals(List.of(2, 3, 3, 3, 6, 7, 8, 10, 10, 10), ss.insertionSort(LS3))
        );
    }

    @Test
    void ipInsSort() {
        IInsertionSort<Integer> is = new InPlaceInsertionSort<>();
        assertAll(
                () -> is.insertionSort(LS1),
                () -> assertEquals(List.of(1, 2, 3, 4, 5), LS1),
                () -> is.insertionSort(LS2),
                () -> assertEquals(List.of(), LS2),
                () -> is.insertionSort(LS3),
                () -> assertEquals(List.of(2, 3, 3, 3, 6, 7, 8, 10, 10, 10), LS3)
        );
    }
}