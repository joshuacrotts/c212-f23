import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTester {
    private final AbstractList<Integer> LS1 = new ArrayList<>(List.of(5, 4, 2, 1, 3));
    private final AbstractList<Integer> LS2 = new ArrayList<>(List.of());
    private final AbstractList<Integer> LS3 = new ArrayList<>(List.of(10, 8, 6, 7, 2, 10, 3, 3, 3, 10));

    @Test
    void fmsTester() {
        IMergeSort<Integer> fms = new FunctionalMergeSort<>();
        assertAll(
                () -> assertEquals(List.of(1, 2, 3, 4, 5), fms.mergeSort(LS1)),
                () -> assertEquals(List.of(), fms.mergeSort(LS2)),
                () -> assertEquals(List.of(2, 3, 3, 3, 6, 7, 8, 10, 10, 10), fms.mergeSort(LS3))
        );
    }

    @Test
    void ipqsTester() {
        IMergeSort<Integer> ipms = new InPlaceMergeSort<>();
        assertAll(
                () -> ipms.mergeSort(LS1),
                () -> assertEquals(List.of(1, 2, 3, 4, 5), LS1),
                () -> ipms.mergeSort(LS2),
                () -> assertEquals(List.of(), LS2),
                () -> ipms.mergeSort(LS3),
                () -> assertEquals(List.of(2, 3, 3, 3, 6, 7, 8, 10, 10, 10), LS3)
        );
    }
}