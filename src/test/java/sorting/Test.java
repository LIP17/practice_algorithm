package sorting;

import datastructure.BinaryHeap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {

//        Integer[] unsorted = new Integer[]{6,5,4,1,3,2,0,9,8,10,7,11, 7, 7, 7};
        Integer[] unsorted = new Integer[]{3,2,1,4,5};
        HeapSort.sort(unsorted);

        for(int i : unsorted) {
            System.out.println(i);
        }
    }
}

