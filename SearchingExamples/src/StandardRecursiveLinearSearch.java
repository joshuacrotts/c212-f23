import java.util.AbstractList;
import java.util.NoSuchElementException;

class StandardRecursiveLinearSearch<V extends Comparable<V>> implements ILinearSearch<V> {

    @Override
    public int linearSearch(AbstractList<V> ls, V v) throws NoSuchElementException {
        if (ls.isEmpty()) { throw new NoSuchElementException(); }
        else if (ls.get(0).equals(v)) { return 0; }
        else { return 1 + linearSearch((AbstractList<V>) ls.subList(1, ls.size()), v); }
    }
}
