import java.util.AbstractList;
import java.util.Comparator;

class TailRecursiveBinarySearch implements IBinarySearch {

    @Override
    public <V extends Comparable<V>> int binarySearch(AbstractList<V> ls, V v) {
        return binarySearchTRHelper(ls, v, 0, ls.size() - 1, Comparable::compareTo);
    }

    @Override
    public <V> int binarySearch(AbstractList<V> ls, V v, Comparator<? super V> c) {
        return binarySearchTRHelper(ls, v, 0, ls.size() - 1, c);
    }

    private <V> int binarySearchTRHelper(AbstractList<V> ls, V v, int low, int high, Comparator<? super V> c) {
        if (low > high) { return -1; }
        else {
            int mid = low + (high - low) / 2;
            if (c.compare(ls.get(mid), v) > 0) { return binarySearchTRHelper(ls, v, low, mid - 1, c); }
            else if (c.compare(ls.get(mid), v) < 0) { return binarySearchTRHelper(ls, v, mid + 1, high, c); }
            else { return mid; }
        }
    }
}
