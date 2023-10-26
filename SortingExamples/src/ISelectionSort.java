import java.util.AbstractList;

interface ISelectionSort<V extends Comparable<V>> {
    AbstractList<V> selectionSort(AbstractList<V> ls);
}
