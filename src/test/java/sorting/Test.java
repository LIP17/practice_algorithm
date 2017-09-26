package sorting;

/**
 * Created by lip on 9/25/17.
 */
public class Test {
    public static void main(String[] args) {

        Integer[] unsorted = new Integer[]{6,5,4,1,3,2,0,9,8,10,7};



        ShellSort.sort(unsorted);



        for(int i : unsorted) {
            System.out.println(i);
        }
    }
}

