package sorting;

import java.util.Arrays;

public class MergeSort {

    public static void sortTopDown(Comparable[] unsorted) {

        if(unsorted == null || unsorted.length <= 1) return;

        int len = unsorted.length - 1;
        int mid = len / 2;

        sort(unsorted, 0, mid);
        sort(unsorted, mid + 1,len);
        merge(unsorted, 0, mid, len);
    }

    private static void sort(Comparable[] unsorted, int start, int end) {
        if(start >= end) return;
        else {
            int mid = start + (end - start) / 2;
            sort(unsorted, start, mid);
            sort(unsorted, mid + 1, end);
            merge(unsorted, start, mid, end);
        }
    }

    private static void merge(Comparable[] unsorted, int start, int mid, int end) {

        int leftIndex = start;
        int rightIndex = mid + 1;

        Comparable[] store = new Comparable[end - start + 1];
        int storeIndex = 0;

        while(leftIndex <= mid && rightIndex <= end) {
            store[storeIndex++] =
                (unsorted[leftIndex].compareTo(unsorted[rightIndex]) < 0)
                        ? unsorted[leftIndex++] : unsorted[rightIndex++];
        }

        if(leftIndex <= mid) {
            System.arraycopy(unsorted, leftIndex, store, storeIndex, mid - leftIndex + 1);
        }

        if(rightIndex <= end){
            System.arraycopy(unsorted, rightIndex, store, storeIndex, end - rightIndex + 1);
        }

        System.arraycopy(store, 0, unsorted, start, end - start + 1);
    }


    public static void main(String[] args) {
        Integer[] unsorted = new Integer[]{6,5,4,1,3,2,0,8};
        Integer[] store = new Integer[]{0,0,0,0,0,0,0,8};

        sortTopDown(unsorted);

//        merge(store, unsorted, 0,3, 7);

        for(Comparable i : unsorted) {
            System.out.println(i.toString());
        }

    }
}
