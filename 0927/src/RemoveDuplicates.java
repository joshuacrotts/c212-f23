import java.util.LinkedHashSet;

class RemoveDuplicates {

    /**
     * Removes duplicates from an array of integers, preserving their order.
     * @param vals
     * @return new integer array of values with preserved order.
     */
    static int[] removeDuplicates(int[] vals) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        for (int v : vals) {
            lhs.add(v);
        }
        int[] newVals = new int[lhs.size()];
        int i = 0;
        for (int v : lhs) {
            newVals[i] = v;
            i++;
        }
        return newVals;
    }
















//    /**
//     * Removes duplicates from an array of integers, preserving their order.
//     * @param vals
//     * @return new integer array of values with preserved order.
//     */
//    static int[] removeDuplicates(int[] vals) {
//        LinkedHashSet<Integer> svals = new LinkedHashSet<>();
//        for (int v : vals) {
//            svals.add(v);
//        }
//        int[] newVals = new int[svals.size()];
//        int idx = 0;
//        for (int v : svals) {
//            newVals[idx++] = v;
//        }
//        return newVals;
//    }
}
