package datastructure;

/**
 * Binary heap meet the requirement that, every node is larger than its child node.
 *
 * The first index in heap is 1, and if node is k, its child node is 2k and 2k + 1
 *
 * */


public class BinaryHeap <Key extends Comparable<Key>>{

    private Key[] arr;
    private int index; // size of the Heap

    public BinaryHeap(int N) {
        this.index = 0;
        arr = (Key[]) new Comparable[N + 1]; // start index is 1, so the size is N + 1
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return this.index;
    }

    public int currentSize() {
        return this.index;
    }

    public void insert(Key elem) {
        if(index == arr.length - 1) throw new RuntimeException("Heap is full");
        arr[++index] = elem;
        swim(index);
    }

    /**
     * retrive top from the heap
     *
     * how: get top, exchange top with the last element, ret
     * */
    public Key getMax() {
        if(isEmpty()) throw new RuntimeException("Heap is empty");
        Key top = arr[1];
        exch(1, index--);
        sink(1);
        return top;
    }

    /**
     * @param k: current index of the element
     *
     *         if the current element is lower than where it is supposed to be, swim up
     * */
    private void swim(int k) {
        while(k > 1 && !less(k, k / 2)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * @param k: current index of the element
     *
     *         if the current element is higher than where it is supposed to be, sink down
     * */
    private void sink(int k) {
        while(2 * k <= index) {
            int j = 2 * k;
            if(j < index && less(j, j + 1)) j++;

            if(!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return arr[i].compareTo(arr[j]) < 0;
    }

    private void exch(int i, int j) {
        Key store = arr[i];
        arr[i] = arr[j];
        arr[j] = store;
    }

    public static void main(String[] args) {

//        Integer[] unsorted = new Integer[]{6,5,4,1,3,2,0,9,8,10,7,11, 7, 7, 7};
//
//        QuickSort.sort(unsorted);
//
//        for(int i : unsorted) {
//            System.out.println(i);
//        }
        BinaryHeap<Integer> bh = new BinaryHeap<>(10);
        bh.insert(1);
        bh.insert(3);
        bh.insert(9);
        bh.insert(4);

        while(!bh.isEmpty()) {
            System.out.println(bh.getMax());
        }
    }
}

