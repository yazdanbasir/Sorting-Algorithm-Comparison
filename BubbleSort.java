/**
 * Checks every two values  in the array against each other.
 * Puts them in order if first value is larger than the second.
 * At the end of every pass, the next largest value is bubbled to the end.
 *
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class BubbleSort<T extends Comparable<? super T>> implements Sorter<T> {
    /**
     * Constructor for objects of class BubbleSort
     */
    public BubbleSort(){}

    /**
     * Main sorting method that loops through the array and swaps values accordingly.
     * 
     * @param y T[]
     */
    public T[] sorting (T[] y) {
        for (int i = 0; i < y.length - 1; i++) {
            
            for (int j = 0; j < y.length - 1 - i; j++) {

                if (y[j+1].compareTo(y[j]) < 0) { // Swaps the values if the first is larger than the second
                    T tmp = y[j];
                    y[j] = y[j+1];
                    y[j+1] = tmp;
                }
            }
        }
        
        return y; // Returns the sorted array
    }
}