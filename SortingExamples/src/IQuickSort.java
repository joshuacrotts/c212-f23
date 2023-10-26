import java.util.AbstractList;

interface IQuickSort<V extends Comparable<V>> {
    AbstractList<V> quicksort(AbstractList<V> ls);
}
