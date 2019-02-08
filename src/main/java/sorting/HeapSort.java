package sorting;

public class HeapSort {

  public static void sort(Comparable[] unsorted) {
    if (unsorted == null || unsorted.length <= 1) {
      return;
    }

    int N = unsorted.length - 1;

    // STEP1: build the MaxHeap
    for (int i = (N - 1) / 2; i >= 0; i--) {
      sink(unsorted, i, N);
    }

    while (N > 0) {
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
   * @param unsorted: unsorted array
   * @param index: the index you want to sink
   * @param size: the size limit to sink
   */
  private static void sink(Comparable[] unsorted, int index, int size) {

    while (2 * index + 1 <= size) {

      int j = 2 * index + 1;

      if (j + 1 <= size && unsorted[j].compareTo(unsorted[j + 1]) < 0) {
        j++;
      }

      exch(unsorted, index, j);
      index = j;
    }
  }

}
