/**
 * Interface that holds the common methods to be used by the sorting algorithms. Implemented by each class.
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public interface Sorter <T> {
    
    /**
     * Main sorting method that holds the operations for each particular sort
     * 
     * @param y T[]
     */
    T[] sorting (T[] y);
}