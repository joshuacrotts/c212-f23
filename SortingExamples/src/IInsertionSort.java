import java.util.AbstractList;

interface IInsertionSort<V extends Comparable<V>> {
    AbstractList<V> insertionSort(AbstractList<V> ls);
}
