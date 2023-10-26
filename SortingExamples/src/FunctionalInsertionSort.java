import java.util.AbstractList;
import java.util.ArrayList;

class FunctionalInsertionSort<V extends Comparable<V>> implements IInsertionSort<V> {
    @Override
    public AbstractList<V> insertionSort(AbstractList<V> ls) {
        if (ls.isEmpty()) { return new ArrayList<>(); }
        else { return insert(ls.get(0), insertionSort((AbstractList<V>) ls.subList(1, ls.size()))); }
    }

    /**
     * Inserts an element into a sorted list of values.
     *
     * @param val value to insert.
     * @param sortedRest a sorted sublist.
     * @return the sorted sublist with the new value inserted.
     */
    private AbstractList<V> insert(V val, AbstractList<V> sortedRest) {
        if (sortedRest.isEmpty()) {
            ArrayList<V> ls = new ArrayList<>();
            ls.add(val);
            return ls;
        } else if (val.compareTo(sortedRest.get(0)) < 0) {
            ArrayList<V> ls = new ArrayList<>();
            ls.add(val);
            ls.addAll(sortedRest);
            return ls;
        } else {
            ArrayList<V> ls = new ArrayList<>();
            ls.add(sortedRest.get(0));
            ls.addAll(insert(val, (AbstractList<V>) sortedRest.subList(1, sortedRest.size())));
            return ls;
        }
    }
}
