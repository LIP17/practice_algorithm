package sorting;

public class SelectionSort {

    /**
     * For each element, find the minimum value's index in its
     * subsequent part, and exchange the value.
     */
    public static void sort(Comparable[] unsorted) {
        if (unsorted == null || unsorted.length <= 1) return;

        int len = unsorted.length;
        for (int i = 0; i < len; i++) {
            int minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (unsorted[minIndex].compareTo(unsorted[j]) > 0) minIndex = j;
            }

            Comparable store = unsorted[i];
            unsorted[i] = unsorted[minIndex];
            unsorted[minIndex] = store;
        }
    }
}

