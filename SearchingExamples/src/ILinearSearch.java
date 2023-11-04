import java.util.AbstractList;
import java.util.NoSuchElementException;

interface ILinearSearch<V extends Comparable<V>> {

    int linearSearch(AbstractList<V> ls, V v) throws NoSuchElementException;
}
