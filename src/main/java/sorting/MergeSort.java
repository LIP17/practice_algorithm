package sorting;

public class MergeSort {

  public static void sort(Comparable[] unsorted) {
    sort(unsorted, 0, unsorted.length - 1);
  }

  public static void sort(Comparable[] unsorted, int start, int end) {
    if(start >= end) return;
    int mid = start + (end - start) / 2;
    sort(unsorted, start, mid);
    sort(unsorted, mid + 1, end);
    merge(unsorted, start, mid + 1, end);
  }

  public static void merge(Comparable[] unsorted, int start, int mid, int end) {

    if (start >= end) {
      return;
    }

    Comparable[] copy = new Comparable[end - start + 1];

    int left = start, right = mid, curr = 0;

    while (left < mid && right <= end) {
       copy[curr++] = (unsorted[left].compareTo(unsorted[right]) < 0) ? unsorted[left++] : unsorted[right++];
    }

    if(left < mid) {
      System.arraycopy(unsorted, left, copy, curr, mid - left);
    }

    if(right <= end) {
      System.arraycopy(unsorted, right, copy, curr, end - right + 1);
    }

    System.arraycopy(copy, 0, unsorted, start, end - start + 1);
  }
}
