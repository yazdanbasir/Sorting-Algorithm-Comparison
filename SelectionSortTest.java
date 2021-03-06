import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SelectionSortTest {
    SelectionSort ss;
    
    /**
     * Default constructor for test class QuickSortFirstTest
     */
    public SelectionSortTest () {
        ss = new SelectionSort();
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        ss = new SelectionSort();
    }
    
    @Test
    public void sortingNormalTest() {   
        Comparable[] toBeSorted = {5, 0, 3, 1, 4, 2};
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, ss.sorting(toBeSorted)); // Sorted array should be {0, 1, 2, 3, 4, 5} now
    }
    
    @Test
    public void sortingBoundaryTest() {
        Comparable[] toBeSorted = {0, 1, 2, 3, 4, 5}; // Already sorted array
        Comparable[] expected = {0, 1, 2, 3, 4, 5}; 
        
        assertArrayEquals(expected, ss.sorting(toBeSorted)); // Already sorted array should not be messed up in any way here
    }
    
    @Test
    public void sortingBoundaryTest2() {
        Comparable[] toBeSorted = {5, 4, 3, 2, 1, 0}; // Reverse order array
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, ss.sorting(toBeSorted)); // Sorted array should be {0, 1, 2, 3, 4, 5} now 
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}