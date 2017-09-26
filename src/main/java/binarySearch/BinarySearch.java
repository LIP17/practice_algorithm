package binarySearch;

public class BinarySearch {

    public int rank(int k, int[] a) {
        if(a == null || a.length == 0 
           || k < a[0] || k > a[a.length - 1]) return -1;

        int start = 0;
        int end = a.length - 1;

        while(start <= end) {

            int mid = start + (end - start) / 2;
            int midVal = a[mid];

            if(k == midVal) return mid;
            else if(k > midVal) start = mid + 1;
            else end = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        assert(new BinarySearch().rank(0, new int[]{1, 2, 3, 4}) == -1);
        assert(new BinarySearch().rank(5, new int[]{1, 2, 3, 4}) == -1);
        assert(new BinarySearch().rank(3, new int[]{1, 2, 3, 4, 5}) == 2);
        assert(new BinarySearch().rank(3, new int[]{1, 2, 3}) == 2);
    }

}



