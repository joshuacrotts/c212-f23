import java.util.AbstractList;
import java.util.NoSuchElementException;

class LoopBinarySearch<V extends Comparable<V>> implements IBinarySearch<V> {

    @Override
    public int binarySearch(AbstractList<V> ls, V v) {
        int low = 0;
        int high = ls.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ls.get(mid).compareTo(v) > 0) { high = mid - 1; }
            else if (ls.get(mid).compareTo(v) < 0) { low = mid + 1; }
            else { return mid; }
        }
        return -1;
    }
}
