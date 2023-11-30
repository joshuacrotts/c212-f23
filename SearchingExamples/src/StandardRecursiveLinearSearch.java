import java.util.AbstractList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class StandardRecursiveLinearSearch implements ILinearSearch {

    @Override
    public <V extends Comparable<V>> int linearSearch(AbstractList<V> ls, V v) {
        return this.linearSearch(ls, v, (o1, o2) -> o1.compareTo(o2));
    }

    public <V> int linearSearch(AbstractList<V> ls, V v, Comparator<? super V> c) {
        if (ls.isEmpty()) { throw new NoSuchElementException(); }
        else if (ls.get(0).equals(v)) { return 0; }
        else { return 1 + linearSearch((AbstractList<V>) ls.subList(1, ls.size()), v, c); }
    }
}
