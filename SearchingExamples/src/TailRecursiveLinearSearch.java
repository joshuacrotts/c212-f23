import java.util.AbstractList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class TailRecursiveLinearSearch implements ILinearSearch {
    @Override
    public <V extends Comparable<V>> int linearSearch(AbstractList<V> ls, V v) {
        return this.linearSearchHelper(ls, v, 0, Comparable::compareTo);
    }

    public <V> int linearSearch(AbstractList<V> ls, V v, Comparator<? super V> c) {
        return this.linearSearchHelper(ls, v, 0, c);
    }

    private <V> int linearSearchHelper(AbstractList<V> ls, V v, int idx, Comparator<? super V> c) {
        if (idx == ls.size()) { return -1; }
        else if (ls.get(idx).equals(v)) { return idx; }
        else { return linearSearchHelper(ls, v, idx + 1, c); }
    }
}
