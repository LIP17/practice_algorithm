package sorting;

public class HeapSort {

    public static void sort(Comparable[] unsorted) {

        // limit of heap
        int N = unsorted.length - 1;

        for(int i = (N - 1) / 2; i >= 0; i--) {
            sink(unsorted, i, N);
        }

        while(N >= 1) {
            exch(unsorted, 0, N--);
            sink(unsorted, 0, N);
        }

    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }

    /**
     * @param arr: the heap
     * @param index: the index you want to sink
     * @param size: the size limit to sink
     * */
    private static void sink(Comparable[] arr, int index, int size) {
        while (2 * index + 1 <= size) {
            int j = 2 * index + 1;
            if(j < size && arr[j].compareTo(arr[j + 1]) < 0) j++;

            if(arr[index].compareTo(arr[j]) >= 0) break;

            exch(arr, index, j);
            index = j;
        }
    }
}
