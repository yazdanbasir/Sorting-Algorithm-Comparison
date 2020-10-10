
/**
 * Checks the next value in the array and puts it in order between the values already checked and sorted.
 * Goes through the entire array and keeps putting the values in order one by one till it reaches the end.
 *
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class InsertionSort <T extends Comparable <? super T>> implements Sorter <T> {

    /**
     * Constructor for objects of class InsertionSort
     */
    public InsertionSort() {}

    /**
     * Main sorting method that holds the rest of the process for Insertion Sort.
     * 
     * @param y T[]
     */
    public T[] sorting (T[] y) {
      for (int nextPos = 1; nextPos < y.length; nextPos++) {
        insert(y, nextPos); // Calls the insert method on each value in the array
      } 
      
      return y; // Returns the sorted array
    }
    
    /**
     * Checks each subsequent value in the array.
     * Checks between which two values that have been checked already does the new one go between.
     * Keeps going until the end of the array is reached
     * 
     * @param y T[]
     * @param nextPos int
     */
    private void insert (T[] y, int nextPos) {
        T nextVal = y[nextPos]; // The next value becomes the next element in the array
         
        while (nextPos > 0 && nextVal.compareTo(y[nextPos-1]) < 0) { // Keeps checking while the array hasn't finished
            y[nextPos] = y[nextPos-1]; // Keeps inserting the values in the correct places
            nextPos--;
        }
        
        y[nextPos] = nextVal; // Moves onto the next value
    }
}