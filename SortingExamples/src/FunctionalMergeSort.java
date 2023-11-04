import java.util.AbstractList;
import java.util.ArrayList;

public class FunctionalMergeSort<V extends Comparable<V>> implements IMergeSort<V> {

    @Override
    public AbstractList<V> mergeSort(AbstractList<V> ls) {
        return this.mergeSortHelper(ls);
    }

    private AbstractList<V> mergeSortHelper(AbstractList<V> ls) {
        if (ls.isEmpty()) { return new ArrayList<>(); }
        else if (ls.size() == 1) {
            AbstractList<V> newLs = new ArrayList<>();
            newLs.add(ls.get(0));
            return newLs;
        } else {
            int mid = (ls.size() - 1) / 2;
            AbstractList<V> leftHalf = mergeSortHelper((AbstractList<V>) ls.subList(0, mid + 1));
            AbstractList<V> rightHalf = mergeSortHelper((AbstractList<V>) ls.subList(mid + 1, ls.size()));
            return merge(leftHalf, rightHalf);
        }
    }

    private AbstractList<V> merge(AbstractList<V> ls1, AbstractList<V> ls2) {
        int i = 0;
        int j = 0;
        AbstractList<V> newLs = new ArrayList<>();

        // Merge the lists, comparing the elements.
        while (i < ls1.size() && j < ls2.size()) {
            if (ls1.get(i).compareTo(ls2.get(j)) < 0) { newLs.add(ls1.get(i++)); }
            else { newLs.add(ls2.get(j++)); }
        }

        // Finish copying ls1.
        while (i < ls1.size()) { newLs.add(ls1.get(i++)); }

        // Finish copying ls2.
        while (j < ls2.size()) { newLs.add(ls2.get(j++)); }

        return newLs;
    }
}
