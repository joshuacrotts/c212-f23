import java.util.AbstractList;
import java.util.Collections;

class InPlaceInsertionSort<V extends Comparable<V>> implements IInsertionSort<V> {

    @Override
    public AbstractList<V> insertionSort(AbstractList<V> ls) {
        for (int i = 1; i < ls.size(); i++) {
            V curr = ls.get(i);
            int j = i - 1;
            while (j >= 0 && ls.get(j).compareTo(curr) > 0) {
                Collections.swap(ls, j+1, j);
                j--;
            }
        }
        return ls;
    }
}
