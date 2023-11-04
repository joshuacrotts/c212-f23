import java.util.AbstractList;

interface IMergeSort<V extends Comparable<V>> {
    AbstractList<V> mergeSort(AbstractList<V> ls);
}
