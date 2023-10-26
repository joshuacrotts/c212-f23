import java.util.AbstractList;
import java.util.Optional;

class FunctionalInsertionSort<V extends Comparable<V>> implements ISelectionSort<V> {

    @Override
    public AbstractList<V> insertionSort(AbstractList<V> ls) {
        if (ls.isEmpty()) { return ls; }
        else {
            // Remember that min returns an Optional, but we know it is non-empty.
            V min = ls.stream().min(V::compareTo).get();
            AbstractList<V> newLs = insertionSort((AbstractList<V>) ls.subList(1, ls.size() - 1));
            newLs.add(0, min);
            return newLs;
        }
    }
}
