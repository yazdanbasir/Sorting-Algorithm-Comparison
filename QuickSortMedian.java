/**
 * Sorts an array by selecting the pivot value to be the median of the first, last, and middle values
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class QuickSortMedian <T extends Comparable <? super T>> extends QuickSorter <T> {
    int start;
    int end;

    /**
     * Constructor for objects of class QuickSortMedian
     */
    public QuickSortMedian() {}

    /**
     * Calls qSort() on the array passed as an argument. Starts the recursive sorting process.
     * 
     * @param y T[]
     */
    public T[] sorting (T[] y) {
        start = 0; // Sets the start to be the first element
        end = y.length-1; // Sets the end to be the last element

        qSort(y, start, end); // Calls qSort on the array y from the first to last element

        return y;
    }

    /**
     * Continues to recursively sort each smaller array as the original array gets smaller
     * 
     * @param a T[]
     * @param fst int
     * @param lst int
     */ 
    private void qSort (T[] a, int fst, int lst) {
        if (fst < lst) { // Checks if the first element being checked comes before the last element being checked
            int pivIndex = partition(a, fst, lst); // Stores the value returned by the partition method

            qSort(a, fst, pivIndex); // Recursively sorts the first half of the array
            qSort(a, pivIndex + 1, lst); // Recursively sorts the second half of the array
        }
    }
    
    /**
     * This is a copy of the method above to be used by the unit tests.
     * Returns the array after the sorting so the unit test can see if it was correct.
     */
    public T[] qSortReturn (T[] a, int fst, int lst) {   
        if (fst < lst) {
            int pivIndex = partition(a, fst, lst);
            
            qSort(a, fst, pivIndex);
            qSort(a, pivIndex + 1, lst);
        }
        
        return a;
    }

    /**
     * Assigns the pivot value of the array being and returns the value partitioned at
     * 
     * @param a T[]
     * @param fst int
     * @param lst int
     */
    public int partition (T[] a, int fst, int lst) {
        BubbleSort b = new BubbleSort(); // Creates a new instance of Bubble Sort
        
        Comparable[] findMedian = {a[fst], a[lst], a[(fst+lst)/2]}; // An array containing the first, last, and middle value of the array 
        
        b.sorting(findMedian); // Bubble sorts the findMedian array to ensure the median value is now the physical middle value of the array
        
        T pivot = (T) findMedian[1]; // Assigns the middle value of the findMedian array as the pivot value

        int u = fst;
        int d = lst;

        while (true) { // Replaces the do while loop as this prevents the Stack Overflow from showing up
            
            while ((pivot.compareTo(a[u]) > 0)) {
                u++; // Keeps moving u up the array as long as a value bigger than pivot does not show up
            }

            while (pivot.compareTo(a[d]) < 0) {
                d--; // Keeps moving d down the array as long as a value smaller than the pivot does not show up
            }

            if (d <= u) { // Checks if u and d have not crossed each other 
                return d; // Returns the partition value at the time
            }

            swap(a, u, d); // Swaps the values of u and d if a change needs to be done
            
            u++; // Keeps incrementing u
            d--; // Keeps decrementing d
        }
    }
    
    /**
     * Accepts an array and two values. Swaps them in the array.
     * 
     * @param a T[]
     * @param x int
     * @param y int
     */
    private void swap(T[] a, int x, int y) { 
        T tmp = a[x]; // Temporarily stores the first value
        a[x] = a[y]; // Assigns the second value in place of the first value
        a[y] = tmp; // Assigns the second the temporarily stored first value
    } 
    
    /**
     * This is a copy of the method above to be used by the unit tests.
     * Returns the array after the swap so the unit test can see if it was correct.
     */
    public T[] swapReturn (T[] a, int x, int y) { 
        T tmp = a[x]; 
        a[x] = a[y]; 
        a[y] = tmp;
        
        return a;
    }
}