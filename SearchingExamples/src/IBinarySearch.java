import java.util.AbstractList;
import java.util.Comparator;

interface IBinarySearch {

    <V extends Comparable<V>> int binarySearch(AbstractList<V> ls, V v);

    <V> int binarySearch(AbstractList<V> ls, V v, Comparator<? super V> c);
}