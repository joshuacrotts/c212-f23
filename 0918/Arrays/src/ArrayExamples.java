class ArrayExamples {

    static double average(int[] array) {
        return 0;
    }

    /**
     * Computes the longest "run" of a set of numbers. The longest run is the longest
     * contiguous sequence of some number.
     * @param chars
     * @return an integer array (tuple) containing two values: index 0 is the number, index 1 is the count/run length.
     */
    static int[] longestRun(int[] chars) {
        int longest = chars[0];
        int maxRun = 1;
        int currentRun = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                currentRun++;
            } else {
                currentRun = 1;
            }

            // If we just exceeded the current longest:
            if (currentRun > maxRun) {
                longest = chars[i];
                maxRun = currentRun;
            }
        }
        // TODO.
        return new int[]{longest, maxRun};
    }
    public static void main(String[] args) {

    }












    /*
            int longest = chars[0];
        int maxRun = 1;
        int currentRun = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                currentRun++;
            } else {
                currentRun = 1;
            }

            // If we just exceeded the current longest:
            if (currentRun > maxRun) {
                longest = chars[i];
                maxRun = currentRun;
            }
        }
        // TODO.
        return new int[]{longest, maxRun};
     */



}