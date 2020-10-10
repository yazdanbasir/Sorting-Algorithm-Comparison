/**
 * Abstract class QuickSorter - Holds the common methods to be used by the QuickSort classes.
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public abstract class QuickSorter <T extends Comparable <? super T>> implements Sorter <T> {
    
    /**
     * Common method between all the classes used to start QuickSort
     * 
     * @param a T[]
     */
    public void sort (T[] a) {
        qSort(a, 0, a.length-1);
    }

    /**
     * This method will be starting the recursive sorting process.
     * 
     * @param a T[]
     * @param fst int
     * @param lst int
     */
    private void qSort (T[] a, int fst, int lst) {}
    
    /**
     * Will return the value at which the array is to be partitioned and further broken down
     * 
     * @param pivot T
     * @param a T[]
     * @param fst int
     * @param lst int
     */
    public int partition(T pivot, T[] a, int fst, int lst) {
        //T pivot = a[fst];
        
        int u = fst;
        int d = lst;
        
        while(true) {

            while ((pivot.compareTo(a[u]) > 0)) {
                u++; 
            }

            while (pivot.compareTo(a[d]) < 0) {
                d--;
            }

            if (d <= u) {
                return d;
            }

            //swap(a, u, d);
            
            u++;
            d--;
        }
    }
}