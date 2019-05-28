package sorting;

/**
 * Introduction to Algorithm:
 * 2.1 Insertion Sort
 */

public class InsertionSort {

  public static void sort(Comparable[] unsorted) {
    if (unsorted == null || unsorted.length == 0) {
      return;
    }

    for (int out = 1; out < unsorted.length; out++) {
      Comparable key = unsorted[out];
      int in = out - 1;

      while (in >= 0 && key.compareTo(unsorted[in]) < 0) {
        unsorted[in + 1] = unsorted[in];
        in--;
      }

      unsorted[in + 1] = key;
    }
  }
}
