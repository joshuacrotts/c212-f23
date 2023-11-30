import java.util.AbstractList;
import java.util.Comparator;

interface ILinearSearch {

    <V extends Comparable<V>> int linearSearch(AbstractList<V> ls, V v);

    <V> int linearSearch(AbstractList<V> ls, V v, Comparator<? super V> c);
}
