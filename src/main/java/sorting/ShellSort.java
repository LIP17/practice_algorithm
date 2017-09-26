package sorting;

public class ShellSort {

    // define the original step length
    private final static int GRANULARITY_FACTOR = 3;

    /**
     * It is similar to selection sort, but with granularity change over time,
     * it will start with the largest granularity, and then decrease for every
     * iteration.
     * */
    public static void sort(Comparable[] unsorted) {
        int len = unsorted.length;

        int step = 1;

        while (step < len / GRANULARITY_FACTOR) step *= GRANULARITY_FACTOR;

        while (step >= 1) {

            for (int i = step; i < len; i ++) {
                for (int j = i; j >= step && unsorted[j].compareTo(unsorted[j - step]) < 0; j -= step) {
                    Comparable store = unsorted[j];
                    unsorted[j] = unsorted[j - step];
                    unsorted[j - step] = store;
                }
            }

            step /= GRANULARITY_FACTOR;
        }
    }
}
