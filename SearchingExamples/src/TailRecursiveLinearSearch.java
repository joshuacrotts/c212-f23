import java.util.AbstractList;
import java.util.NoSuchElementException;

class TailRecursiveLinearSearch<V extends Comparable<V>> implements ILinearSearch<V> {
    @Override
    public int linearSearch(AbstractList<V> ls, V v) throws NoSuchElementException {
        return this.linearSearchHelper(ls, v, 0);
    }

    private int linearSearchHelper(AbstractList<V> ls, V v, int idx) {
        if (idx == ls.size()) { throw new NoSuchElementException(); }
        else if (ls.get(idx).equals(v)) { return idx; }
        else { return linearSearchHelper(ls, v, idx + 1); }
    }
}
