import java.util.AbstractList;
import java.util.Collections;

class InPlaceSelectionSort<V extends Comparable<V>> implements ISelectionSort<V> {
    @Override
    public AbstractList<V> selectionSort(AbstractList<V> ls) {
        for (int i = 0; i < ls.size(); i++) {
            V min = ls.get(i);
            int minIdx = 0;
            boolean needToSwap = false;
            for (int j = i + 1; j < ls.size(); j++) {
                // Find the minimum.
                if (ls.get(j).compareTo(min) < 0) {
                    min = ls.get(j);
                    minIdx = j;
                    needToSwap=true;
                }
            }
            if(needToSwap) { Collections.swap(ls, minIdx, i); }
        }
        return ls;
    }
}
