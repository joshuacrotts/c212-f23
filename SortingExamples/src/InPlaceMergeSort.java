import java.util.AbstractList;
import java.util.ArrayList;

public class InPlaceMergeSort<V extends Comparable<V>> implements IMergeSort<V> {

    @Override
    public AbstractList<V> mergeSort(AbstractList<V> ls) {
        this.mergeSortHelper(ls, 0, ls.size() - 1);
        return ls;
    }

    /**
     *
     *
     * @param ls
     * @param low
     * @param high
     */
    private void mergeSortHelper(AbstractList<V> ls, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSortHelper(ls, low, mid);
            mergeSortHelper(ls, mid + 1, high);
            merge(ls, low, mid, high);
        }
    }

    /**
     *
     *
     * @param ls
     * @param low
     * @param mid
     * @param high
     */
    private void merge(AbstractList<V> ls, int low, int mid, int high) {
        // Create two auxiliary arrays.
        AbstractList<V> left = new ArrayList<>();
        AbstractList<V> right = new ArrayList<>();

        // Copy the elements over into the auxiliary lists.
        for (int i = low; i <= mid; i++) { left.add(ls.get(i)); }
        for (int j = mid + 1; j <= high; j++) { right.add(ls.get(j)); }

        int mergedIdx = low;
        int i = 0;
        int j = 0;

        // Merge the elements into the existing list.
        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) < 0) { ls.set(mergedIdx++, left.get(i++)); }
            else { ls.set(mergedIdx++, right.get(j++)); }
        }

        // Copy the rest of the elements over.
        while (i < left.size()) { ls.set(mergedIdx++, left.get(i++)); }
        while (j < right.size()) { ls.set(mergedIdx++, right.get(j++)); }
    }
}
