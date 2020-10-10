import java.util.*;

/**
 * Breaks down the array into two parts right down the middle.
 * Recursively sorts each half and then puts them back together in total order.
 * 
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class MergeSort <T extends Comparable <? super T>> implements Sorter <T> {
    int start; // Holds the index value to start sorting at
    int end; // Holds the index value to stop sorting at
    
    /**
     * Constructor for objects of class MergeSort
     */
    public MergeSort() {}

    /**
     * Main sorting method that starts the sorting and calls the recursive sort() method.
     * 
     * @param y T[]
     */
    public T[] sorting (T[] y) {
        start = 0; // Starting index of the array
        end = y.length-1; // Last index of the array
        
        sort(y, start, end); // Calls sort on the array from start to the end
        
        return y;
    }

    /**
     * Recursively sorts each half of the original array.
     * Calls merge() to put them back together.
     * 
     * @param y T[]
     * @param start int
     * @param end int
     */
    public void sort (T[] y, int start, int end) {
        if (start >= end) { // Checks if array has one element or is empty
            return;
        }
        
        int half = (start+end) / 2; // The half index is the average index of the first and last
        
        sort(y, start, half); // Calls sort on the first half
        sort(y, half + 1, end); // Calls sort on the second half
        
        merge(y, start, half, end); // Merges both halves together
    }

    /**
     * Puts the sorted halves back in order into one array by checking the values against each other.
     * 
     * @param y T[]
     * @param start int
     * @param half int
     * @param end int
     */
    private void merge(T[] y, int start, int half, int end) {
        T[] b = Arrays.copyOfRange(y, start, half+1); // Creates a copy of the original array
        
        int i = 0; // Index in b
        int j = half+1; // Index in second half of a
        int k = start; // Index in merged a
        
        while (i < b.length && j <= end ) { // Checks if index i being checked is still inside b and whether j hasn't reached end of the array
            
            if (b[i].compareTo(y[j]) <= 0) { // Checks if values in the first half are smaller than second half
                y[k++] = b[i++]; // Puts them in order, increments value to move to next
            } else { // Otherwise, checks if second half value is bigger than first half
                y[k++] = y[j++]; // Puts them in order, increments value to move to next
            }
        }
        
        while (i < b.length) { // Loops through the array once more to check all values
            y[k++] = b[i++]; // Puts them in order, increments to move to next
        }
    }
}