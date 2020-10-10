import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class QuickSortRandomTest.
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class QuickSortRandomTest {
    QuickSortRandom qs;
    
    /**
     * Default constructor for test class QuickSortFirstTest
     */
    public QuickSortRandomTest () {
        qs = new QuickSortRandom();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        qs = new QuickSortRandom();
    }
    
    @Test
    public void sortingNormalTest() {
        Comparable[] toBeSorted = {5, 0, 3, 1, 4, 2};
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, qs.sorting(toBeSorted)); // The sorted array should now be {0, 1, 2, 3, 4, 5}
    }
    
    @Test
    public void sortingBoundaryTest() {
        Comparable[] toBeSorted = {0, 1, 2, 3, 4, 5}; // The test array should remain unchanged at the end
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, qs.sorting(toBeSorted));
    }
    
    @Test
    public void sortingBoundaryTest2() {
        Comparable[] toBeSorted = {5, 4, 3, 2, 1, 0}; //This is now testing a reverse sorted array
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, qs.sorting(toBeSorted)); // The sorted array should now be {0, 1, 2, 3, 4, 5}
    }
    
    @Test
    public void qSortNormalTest() {
        Comparable[] toBeSorted = {5, 0, 3, 1, 4, 2};
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, qs.qSortReturn(toBeSorted, 0, toBeSorted.length-1)); // The sorted array should now be {0, 1, 2, 3, 4, 5}
    }  
    
    @Test
    public void qSortBoundaryTest() {
        Comparable[] toBeSorted = {0, 1, 2, 3, 4, 5}; // The test array should remain unchanged at the end
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, qs.qSortReturn(toBeSorted, 0, toBeSorted.length-1)); // The sorted array should now be {0, 1, 2, 3, 4, 5}
    } 
    
    @Test
    public void qSortBoundaryTest2() {
        Comparable[] toBeSorted = {5, 4, 3, 2, 1, 0}; // This is now testing a reverse sorted array
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, qs.qSortReturn(toBeSorted, 0, toBeSorted.length-1)); // The sorted array should now be {0, 1, 2, 3, 4, 5}
    }    
    
    /*
     * The test for partition has been commented out because the partition
     * value changes along with the pivot value as this version of
     * Quicksort uses a random pivot. So, it cannot be accurately tested as
     * the pivot is constantly changing.
     */
    
    // @Test
    // public void partitionTest() {
        // Comparable[] toBeSorted = {5, 0, 3, 1, 4, 2};
        // Comparable expected = 1;
        
        // assertEquals(expected, qs.partition(toBeSorted, 0, toBeSorted.length-1));
    // }
    
    @Test
    public void swapTest() {
        Comparable[] toBeSwapped = {5, 3};
        Comparable[] expected = {3, 5};        
        
        assertEquals(expected, qs.swapReturn(toBeSwapped, 0, 1)); // The swapped array should be {3,5}
    }  
    
    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}
