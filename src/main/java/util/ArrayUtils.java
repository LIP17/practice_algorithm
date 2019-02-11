package util;

import java.util.Random;

public class ArrayUtils {

  public static void exchange(Object[] arr, int i, int j) {
    if (arr == null) {
      return;
    }

    Object holder = arr[i];
    arr[i] = arr[j];
    arr[j] = holder;
  }

  public static void shuffle(Object[] arr) {
    if (arr == null || arr.length <= 1) {
      return;
    }

    Random rand = new Random();

    for (int i = 1; i < arr.length; i++) {
      int exchangeIndex = rand.nextInt(i);
      Object store = arr[exchangeIndex];
      arr[exchangeIndex] = arr[i];
      arr[i] = store;
    }
  }
}
