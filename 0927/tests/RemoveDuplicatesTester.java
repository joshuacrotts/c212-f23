import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesTester {

    @Test
    void removeDuplicatesTest1() {
        Assertions.assertArrayEquals(new int[]{5, 6, 2, 3, 4},
                RemoveDuplicates.removeDuplicates(new int[]{5, 6, 6, 2, 2, 3, 4, 4}));
    }

    @Test
    void removeDuplicatesTest2() {
        Assertions.assertArrayEquals(new int[]{}, RemoveDuplicates.removeDuplicates(new int[]{}));
    }
    @Test
    void removeDuplicatesTest3() {
        Assertions.assertArrayEquals(new int[]{5}, RemoveDuplicates.removeDuplicates(new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5}));
    }

    @Test
    void removeDuplicatesTest4() {
        Assertions.assertArrayEquals(new int[]{1, 4, 9, 16, 25}, RemoveDuplicates.removeDuplicates(new int[]{1, 4, 9, 16, 25}));
    }
}