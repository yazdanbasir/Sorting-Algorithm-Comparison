import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BubbleSortTest.
 */
public class BubbleSortTest {
    BubbleSort bs;
    
    /**
     * Default constructor for test class QuickSortFirstTest
     */
    public BubbleSortTest () {
        bs = new BubbleSort();
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        bs = new BubbleSort();
    }
    
    @Test
    public void sortingNormalTest() {
        Comparable[] toBeSorted = {5, 0, 3, 1, 4, 2};
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, bs.sorting(toBeSorted)); // Sorted array should be {1,2,3,4,5}
    }
    
    @Test
    public void sortingBoundaryTest() {
        Comparable[] toBeSorted = {0, 1, 2, 3, 4, 5}; // Already sorted array
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, bs.sorting(toBeSorted)); // Already sorted array should not be messed up
    }
    
    @Test
    public void sortingBoundaryTest2() {
        Comparable[] toBeSorted = {5, 4, 3, 2, 1, 0}; // Reverse sorted array
        Comparable[] expected = {0, 1, 2, 3, 4, 5};
        
        assertArrayEquals(expected, bs.sorting(toBeSorted)); // Sorted array should be {1,2,3,4,5}
    }
    
    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown() {}
}