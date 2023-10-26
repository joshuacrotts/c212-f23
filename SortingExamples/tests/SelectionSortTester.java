import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionalSelectionSortTester {

    private final AbstractList<Integer> LS1 = new ArrayList<>(List.of(5, 4, 2, 1, 3));
    private final AbstractList<Integer> LS2 = new ArrayList<>(List.of());
    private final AbstractList<Integer> LS3 = new ArrayList<>(List.of(10, 8, 6, 7, 2, 10, 3, 3, 3, 10));

    @Test
    void fSelSort() {
        ISelectionSort<Integer> ss = new FunctionalSelectionSort<>();
        assertAll(
                () -> assertEquals(List.of(1, 2, 3, 4, 5), ss.selectionSort(LS1)),
                () -> assertEquals(List.of(), ss.selectionSort(LS2)),
                () -> assertEquals(List.of(2, 3, 3, 3, 6, 7, 8, 10, 10, 10), ss.selectionSort(LS3))
        );
    }
}