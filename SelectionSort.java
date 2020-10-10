import java.util.*;

/**
 * Finds the smallest value of the array and puts it the front.
 * Doesn't consider the previous smallest in the next pass and looks for the next minimum.
 * Sorts the entire array until no more minimums are present and no more swaps need to be performed.
 *
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class SelectionSort<T extends Comparable<? super T>> implements Sorter<T> {

    /**
     * Constructor for objects of class SelectionSort
     */
    public SelectionSort() {}

    /**
     * Keeps finding the next smallest value in the array and puts it at the start to sort the array.
     * 
     * @param y T[]
     */
    public T[] sorting (T[] y) {
        int n = y.length;

        for (int fill = 0; fill < n-1; fill++) { 

            int posMin = fill; // The position the loop is currently at becomes the temporary minimum value to be compared to

            for (int nxt = fill +1 ; nxt < n; nxt++) {

                if (y[nxt].compareTo(y[posMin]) < 0) { // Checks if the next value is smaller
                    posMin = nxt; // Replaces the minimum if it is
                }
            } 
            
            T tmp = y[fill];
            y[fill] = y[posMin];
            y[posMin] = tmp; // Swaps the values at the end to make sure the minimum value has been added after the previous minimum
        }

        return y;
    }
}
