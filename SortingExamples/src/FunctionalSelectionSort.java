import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

class FunctionalSelectionSort<V extends Comparable<V>> implements ISelectionSort<V> {

    /**
     *
     * @param ls
     * @return
     */
    @Override
    public AbstractList<V> selectionSort(AbstractList<V> ls) {
        if (ls.isEmpty() || ls.size() == 1) { return ls; }
        else {
            // Remember that min returns an Optional, but we know it is non-empty.
            int minIdx = IntStream.range(0, ls.size())
                                  .boxed()
                                  .min((i1, i2) -> ls.get(i1).compareTo(ls.get(i2)))
                                  .get();

            // Swap the minimum element with the first element.
            Collections.swap(ls, 0, minIdx);

            // Sort the rest of the list (excluding the first element).
            AbstractList<V> sortedRest = selectionSort(new ArrayList<>(ls.subList(1, ls.size())));

            // Construct the final sorted list.
            AbstractList<V> sortedList = new ArrayList<>();
            sortedList.add(ls.get(0));
            sortedList.addAll(sortedRest);
            return sortedList;
        }
    }
}
