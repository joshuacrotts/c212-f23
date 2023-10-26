import java.util.AbstractList;
import java.util.stream.Collectors;


class FunctionalQuickSort<V extends Comparable<V>> implements IQuickSort<V> {

    @Override
    public AbstractList<V> quicksort(AbstractList<V> ls) {
        if (ls.isEmpty()) { return ls; }
        else {
            // Choose a random pivot.
            V pivot = ls.get((int) (Math.random() * ls.size()));

            // Sort the left-half.
            AbstractList<V> leftHalf = (AbstractList<V>) ls.stream()
                                                           .filter(x -> x.compareTo(pivot) < 0)
                                                           .collect(Collectors.toList());
            AbstractList<V> leftSorted = quicksort(leftHalf);

            // Sort the right-half.
            AbstractList<V> rightHalf = (AbstractList<V>) ls.stream()
                                                            .filter(x -> x.compareTo(pivot) > 0)
                                                            .collect(Collectors.toList());
            AbstractList<V> rightSorted = quicksort(rightHalf);

            // Get all elements equal to the pivot.
            AbstractList<V> equal = (AbstractList<V>) ls.stream()
                                                        .filter(x -> x.compareTo(pivot) == 0)
                                                        .collect(Collectors.toList());

            // Merge the three.
            leftSorted.addAll(equal);
            leftSorted.addAll(rightSorted);
            return leftSorted;
        }
    }
}