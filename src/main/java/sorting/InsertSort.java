package sorting;

public class InsertSort {
    public static void sort(Comparable[] unsorted) {
        if(unsorted == null || unsorted.length <= 1) return;

        int len = unsorted.length;
        /**
         * For every element, sort the partial array behind it.
         *
         * Replace 1 by 1 from current position to the first element that larger than it.
         *
         * */
        for(int i = 1; i < len; i++) {
            for (int j = i; j > 0 && unsorted[j].compareTo(unsorted[j - 1]) < 0; j--) {
                Comparable store = unsorted[j];
                unsorted[j] = unsorted[j - 1];
                unsorted[j - 1] = store;
            }
        }
    }
}
