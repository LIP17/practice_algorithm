package sorting;

import static util.ArrayUtils.exchange;

import util.ArrayUtils;

public class QuickSort {

  public static void sort(Comparable[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    ArrayUtils.shuffle(arr);
    sort(arr, 0, arr.length - 1);
  }

  private static void sort(Comparable[] arr, int start, int end) {
    if (start >= end) {
      return;
    }

    int p = partition(arr, start, end);
    sort(arr, start, p - 1);
    sort(arr, p + 1, end);
  }

  private static int partition(Comparable[] arr, int start, int end) {

    Comparable pivot = arr[start];
    int left = start, right = end + 1;

    while (true) {
      while (arr[++left].compareTo(pivot) < 0 && left < end);
      while (arr[--right].compareTo(pivot) > 0 && right > start);

      if (left >= right) {
        break;
      }
      exchange(arr, left, right);
    }

    exchange(arr, start, right);
    return right;
  }

}
