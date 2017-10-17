package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle the order of an array
 */
public class Shuffle {

    public static void shuffle(Object[] arr) {
        if(arr == null || arr.length <= 1) return;

        Random rand = new Random();

        for(int i = 1; i < arr.length; i++) {
            int exchangeIndex = rand.nextInt(i);
            Object store = arr[exchangeIndex];
            arr[exchangeIndex] = arr[i];
            arr[i] = store;
        }
    }

    public static void main(String[] args) {
        Integer[] input = new Integer[]{1,2,3,4};

        Shuffle.shuffle(input);

        Arrays.stream(input).forEach(i -> System.out.println(i));
    }

}
