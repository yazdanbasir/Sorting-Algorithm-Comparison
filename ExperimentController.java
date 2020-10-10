import java.util.*;

/**
 * Holds all the methods to test each sorting algorithm for its time.
 * Also holds the methods to create the test arrays and the ones used to test the native implementation of Java's Merge Sort and QuickSort.
 * 
 * @author Yazdan Basir & Jannat-ul-Ferdous
 */
public class ExperimentController {
    long startTime; // Holds the time at the start of the experiment
    long stopTime; // Holds the time at the end of the experiment

    public static Integer[] tester; // Test array that is overridden with new elements before each test
    public static int[] tester2; // Test array that is used to test the time of Java's native sorting methosd
    public static int[] current; // Holds the current size of array being used to avoid having to modify it for each type of array

    public static ExperimentController ec = new ExperimentController();

    public static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        int[] smallNumberOfElements = {100, 500, 1000, 1500, 2000, 2500, 3000, 3500, 4000, 4500, 5000};
        int[] mediumNumberOfElements = {10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000};
        
        // The large array used to test QuickSort 
        int[] largeNumberOfElements = {100000, 250000, 500000, 750000, 1000000, 2500000, 5000000, 7500000, 10000000};
        
        // The large array used to test Merge Sort
        //int[] largeNumberOfElements = {100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000};

        System.out.println("SMALL ARRAYS TEST:");
        System.out.println();

        current = smallNumberOfElements;

        System.out.println("Random Unsorted Array Test:");
        randomArrayTest();
        System.out.println();

        System.out.println("Partially Sorted Array Test:");
        partiallySortedArrayTest();
        System.out.println();

        System.out.println("Sorted Array Test:");
        sortedArrayTest();
        System.out.println();

        System.out.println("Reverse Order Sorted Array Test:");
        reverseSortedArrayTest();
        System.out.println();

        System.out.println("MEDIUM ARRAYS TEST:");
        System.out.println();

        current = mediumNumberOfElements;

        System.out.println("Random Unsorted Array Test:");
        randomArrayTest();
        System.out.println();

        System.out.println("Partially Sorted Array Test:");
        partiallySortedArrayTest();
        System.out.println();

        System.out.println("Sorted Array Test:");
        sortedArrayTest();
        System.out.println();

        System.out.println("Reverse Order Sorted Array Test:");
        reverseSortedArrayTest();
        System.out.println();

        System.out.println("LARGE ARRAYS TEST:");
        System.out.println();

        current = largeNumberOfElements;

        System.out.println("Random Unsorted Array Test:");
        randomArrayTest();
        System.out.println();

        System.out.println("Partially Sorted Array Test:");
        partiallySortedArrayTest();
        System.out.println();

        System.out.println("Sorted Array Test:");
        sortedArrayTest();
        System.out.println();

        System.out.println("Reverse Order Sorted Array Test:");
        reverseSortedArrayTest();
        System.out.println();
        
        // The following is a test of each sorting algorithm against the Professor's test array

        // BubbleSort bs = new BubbleSort();
        // SelectionSort ss = new SelectionSort();
        // InsertionSort is = new InsertionSort();
        // MergeSort ms = new MergeSort();
        // QuickSortFirst qs1 = new QuickSortFirst();
        // QuickSortMedian qs2 = new QuickSortMedian();
        // QuickSortRandom qs3 = new QuickSortRandom();

        // ProfTest a = new ProfTest();
        // bs.sorting((Comparable[]) a.testArray);
        // System.out.println("Bubble Sort:");
        // System.out.println(Arrays.toString(a.testArray));
        // System.out.println();

        // ProfTest b = new ProfTest();
        // ss.sorting((Comparable[]) a.testArray);
        // System.out.println("Selection Sort:");
        // System.out.println(Arrays.toString(a.testArray));
        // System.out.println();

        // ProfTest c = new ProfTest();
        // is.sorting((Comparable[]) a.testArray);
        // System.out.println("Insertion Sort:");
        // System.out.println(Arrays.toString(a.testArray));
        // System.out.println();

        // ProfTest d = new ProfTest();
        // ms.sorting((Comparable[]) a.testArray);
        // System.out.println("Merge Sort:");
        // System.out.println(Arrays.toString(a.testArray));
        // System.out.println();

        // ProfTest e = new ProfTest();
        // qs1.sorting((Comparable[]) e.testArray);
        // System.out.println("QuickSort First:");
        // System.out.println(Arrays.toString(e.testArray));
        // System.out.println();

        // ProfTest f = new ProfTest();
        // qs2.sorting((Comparable[]) f.testArray);
        // System.out.println("QuickSort Median:");
        // System.out.println(Arrays.toString(f.testArray));
        // System.out.println();

        // ProfTest g = new ProfTest();
        // qs3.sorting((Comparable[]) g.testArray);
        // System.out.println("QuickSort Random:");
        // System.out.println(Arrays.toString(g.testArray));
        // System.out.println();
    }

    /**
     * Creates a random unsorted array for testing purposes.
     */
    public static void randomArrayTest() {
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < current.length; i++) {
            tester = new Integer[current[i]]; // Creates an array the size of the first element in current

            for (int j = 0; j < tester.length; j++) {
                tester[j] = random.nextInt(current[i]); // Assigns a random value to each index
            }
            
            // Currently being tested for the time it takes for QuickSortRandom
            System.out.println("Number of elements: " + current[i] + ". Time taken: " + ec.timeQuickSortRandom());
        }
    }

    /**
     * Creates a completely sorted array for testing purposes.
     */
    public static void sortedArrayTest() {
        for (int i = 0; i < current.length; i++) {
            tester = new Integer[current[i]];

            for (int j = 0; j < tester.length; j++) {
                tester[j] = j; // Assigns each index the current value of j to ensure order is maintained
            }

            // Currently being tested for the time it takes for QuickSortRandom
            System.out.println("Number of elements: " + current[i] + ". Time taken: " + ec.timeQuickSortRandom());
        }
    }

    /**
     * Creates a partially sorted array for testing purposes.
     */
    public static void partiallySortedArrayTest() {
        Random rand = new Random(System.currentTimeMillis());

        for (int i = 0; i < current.length; i++) {
            tester = new Integer[current[i]]; // Creates an array the size of the first element in current

            for (int j = 0; j < tester.length; j = j + 2) {
                int max = i*10;
                int min = max-10;

                tester[j] = rand.nextInt((max - min) + 1) + min; // Assigns the index a value in the range
                tester[j+1] = rand.nextInt((max - min) + 1) + min; // Assigns the next index a value in the range
            }

            // Currently being tested for the time it takes for QuickSortRandom
            System.out.println("Number of elements: " + current[i] + ". Time taken: " + ec.timeQuickSortRandom());
        }
    }

    /**
     * Creates a reverse sorted array for testing purposes.
     */
    public static void reverseSortedArrayTest() {
        for (int i = 0; i < current.length; i++) {
            tester = new Integer[current[i]];

            for (int j = 0; j < tester.length; j++) {
                tester[j] = tester.length - 1 - j; // Assigns each value of the array in decreasing order to maintain reverse order
            }

            // Currently being tested for the time it takes for QuickSortRandom
            System.out.println("Number of elements: " + current[i] + ". Time taken: " + ec.timeQuickSortRandom());
        }
    }

    /**
     * Creates a new instance of BubbleSort() and tests it for the time taken against a particular array
     */
    public long timeBubbleSort() {
        BubbleSort bubbleSort = new BubbleSort();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        bubbleSort.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Creates a new instance of SelectionSort() and tests it for the time taken against a particular array
     */
    public long timeSelectionSort() {
        SelectionSort selectionSort = new SelectionSort();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        selectionSort.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Creates a new instance of InsertionSort() and tests it for the time taken against a particular array
     */
    public long timeInsertionSort() {
        InsertionSort insertionSort = new InsertionSort();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        insertionSort.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Creates a new instance of MergeSort() and tests it for the time taken against a particular array
     */
    public long timeMergeSort() {
        MergeSort mergeSort = new MergeSort();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        mergeSort.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Tests Java's native Merge Sort for the time taken against a particular array
     */
    public long timeNativeMergeSort() {
        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        Arrays.sort(tester); // No casting needed here as tester is already type Integer

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Tests Java's native QuickSort for the time taken against a particular array
     */
    public long timeNativeQuickSort() {
        tester2 = new int[tester.length];

        for (int i = 0; i < tester.length; i++) {
            tester2[i] = (int) tester[i]; // Casts the array to type int to ensure Java calls QuickSort
        }

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        Arrays.sort(tester2);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time       
    }

    /**
     * Creates a new instance of QuickSortFirst() and tests it for the time taken against a particular array
     */
    public long timeQuickSortFirst() {
        QuickSortFirst quickSortFirst = new QuickSortFirst();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        quickSortFirst.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Creates a new instance of QuickSortMedian() and tests it for the time taken against a particular array
     */
    public long timeQuickSortMedian() {
        QuickSortMedian quickSortMedian = new QuickSortMedian();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        quickSortMedian.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }

    /**
     * Creates a new instance of QuickSortRandom() and tests it for the time taken against a particular array
     */
    public long timeQuickSortRandom() {
        QuickSortRandom quickSortRandom = new QuickSortRandom();

        startTime = System.currentTimeMillis(); // Saves the time before the sorting starts

        quickSortRandom.sorting(tester);

        stopTime = System.currentTimeMillis(); // Saves the time after sorting ends

        return stopTime - startTime; // Returns the difference between the ending time and starting time
    }
}