package sorting;

/**
 * Created by lip on 10/15/17.
 */
public class QuickSort {

    public static void sort(Comparable[] arr) {
        if(arr == null || arr.length <= 1) return;

        Shuffle.shuffle(arr);

        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int start, int end) {
        if(start >= end) return;

        int p = partition(arr, start, end);
        sort(arr, start, p - 1);
        sort(arr, p + 1, end);
    }

    private static int partition(Comparable[] arr, int start, int end) {

        int low = start, high = end + 1;
        Comparable pivot = arr[low];

        while(true) {
            while(arr[++low].compareTo(pivot) < 0 && low < end);
            while(arr[--high].compareTo(pivot) > 0 && high > start);

            if(low >= high) break;

            exchange(arr, low, high);
        }

        exchange(arr, start, high);
        return high;
    }


    private static void exchange(Object[] arr, int i, int j) {
        Object store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }

    public static void main(String[] args) {
        Integer[] i = new Integer[]{3,1,2,5,4};

        QuickSort.sort(i);
    }
}
