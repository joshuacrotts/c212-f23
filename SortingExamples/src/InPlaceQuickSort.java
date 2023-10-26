import java.util.AbstractList;
import java.util.Collections;
import java.util.Random;


class InPlaceQuickSort<V extends Comparable<V>> implements IQuickSort<V> {

    /**
     * Sorts a given List, whose elements are comparable, in ascending order.
     *
     * @param ls the List to sort.
     * @param <V extends Comparable<V>> the type of the elements in the List.
     * @return a new List that is sorted in ascending order.
     */
    @Override
    public AbstractList<V> quicksort(AbstractList<V> ls) {
        this.quicksortHelper(ls, 0, ls.size() - 1);
        return ls;
    }

    /**
     *
     * @param ls
     * @param low
     * @param high
     */
    private void quicksortHelper(AbstractList<V> ls, int low, int high) {
        if (low < high) {
            int pivot = quicksortPartition(ls, low, high);
            quicksortHelper(ls, low, pivot - 1);
            quicksortHelper(ls, pivot + 1, high);
        }
    }

    /**
     *
     * @param ls
     * @param low
     * @param high
     * @return
     */
    private int quicksortPartition(AbstractList<V> ls, int low, int high) {
        int rand = new Random().nextInt(high - low + 1) + low;
        Collections.swap(ls, rand, high);
        V pivot = ls.get(high);
        int prevLowest = low;
        for (int i = low; i <= high; i++) {
            if (ls.get(i).compareTo(pivot) < 0) {
                Collections.swap(ls, i, prevLowest++);
            }
        }
        Collections.swap(ls, prevLowest, high);
        return prevLowest;
    }
}