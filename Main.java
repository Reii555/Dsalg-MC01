public class Main {
    public static void main(String[] args) {
        /* Available dataset files:
            almostsorted.txt
            random100.txt
            random25000.txt
            random50000.txt
            random75000.txt
            random100000.txt
            totallyreversed.txt
        */

        // Initialize objects and variables used for measuring execution time
        FileReader fileReader = new FileReader();
        SortingAlgorithms sorter = new SortingAlgorithms();
        long startTime, endTime, executionTimeMs;
        double executionTimeSec;

        // Change the filename here to test different datasets (Copy-paste from list above!)
        String filePath = "data/";
        String filename = "totallyreversed.txt";

        Record[] records = fileReader.readFile(filePath + filename);

        // Make copies so each algorithm gets the same unsorted input
        Record[] arr1 = records.clone();
        Record[] arr2 = records.clone();
        Record[] arr3 = records.clone();
        Record[] arr4 = records.clone();

        System.out.println("\nSorting data file: " + filename + "\n");

        // Just comment out other algorithms to test individually!
        
        /*** Insertion Sort ***/
        /*System.out.println("============= Insertion Sort =============");
        sorter.resetStepCount(); // Reset step count before sorting
        System.out.println("Is sorted? (Before): " + isSorted(arr1));
        startTime = System.currentTimeMillis();
        sorter.insertionSort(arr1, arr1.length);
        endTime = System.currentTimeMillis();
        System.out.println("Is sorted? (After): " + isSorted(arr1));
        executionTimeMs = endTime - startTime; // Execution time in milliseconds
        executionTimeSec = executionTimeMs / 1000.0; // Convert to seconds
        System.out.println("Execution Time (in milliseconds): " + executionTimeMs + " ms");
        System.out.println("Execution Time (in seconds): " + executionTimeSec + " s");
        System.out.println("Empirical Frequency Count: " + sorter.getStepCount());
        System.out.println("==========================================\n"); 

        /*** Selection Sort ***/
        /*System.out.println("============= Selection Sort =============");
        sorter.resetStepCount(); // Reset step count before sorting
        System.out.println("Is sorted? (Before): " + isSorted(arr2));
        startTime = System.currentTimeMillis();
        sorter.selectionSort(arr2, arr2.length);
        endTime = System.currentTimeMillis();
        System.out.println("Is sorted? (After): " + isSorted(arr2));
        executionTimeMs = endTime - startTime; // Execution time in milliseconds
        executionTimeSec = executionTimeMs / 1000.0; // Convert to seconds
        System.out.println("Execution Time (in milliseconds): " + executionTimeMs + " ms");
        System.out.println("Execution Time (in seconds): " + executionTimeSec + " s");
        System.out.println("Empirical Frequency Count: " + sorter.getStepCount());
        System.out.println("==========================================\n");

        /*** Merge Sort ***/
        /*System.out.println("=============== Merge Sort ===============");
        sorter.resetStepCount(); // Reset step count before sorting
        System.out.println("Is sorted? (Before): " + isSorted(arr3));
        startTime = System.currentTimeMillis();
        sorter.mergeSort(arr3, 0, arr3.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("Is sorted? (After): " + isSorted(arr3));
        executionTimeMs = endTime - startTime; // Execution time in milliseconds
        executionTimeSec = executionTimeMs / 1000.0; // Convert to seconds
        System.out.println("Execution Time (in milliseconds): " + executionTimeMs + " ms");
        System.out.println("Execution Time (in seconds): " + executionTimeSec + " s");
        System.out.println("Empirical Frequency Count: " + sorter.getStepCount());
        System.out.println("==========================================\n"); 

        /*** Bubble Sort ***/
        System.out.println("============== Bubble Sort ===============");
        sorter.resetStepCount(); // Reset step count before sorting
        System.out.println("Is sorted? (Before): " + isSorted(arr4));
        startTime = System.currentTimeMillis();
        sorter.bubbleSort(arr4, arr4.length);
        endTime = System.currentTimeMillis();
        System.out.println("Is sorted? (After): " + isSorted(arr4));
        executionTimeMs = endTime - startTime; // Execution time in milliseconds
        executionTimeSec = executionTimeMs / 1000.0; // Convert to seconds
        System.out.println("Execution Time (in milliseconds): " + executionTimeMs + " ms");
        System.out.println("Execution Time (in seconds): " + executionTimeSec + " s");
        System.out.println("Empirical Frequency Count: " + sorter.getStepCount());
        System.out.println("==========================================\n");
    }

    /*
     * Helper method to check if array is sorted
     */
    private static boolean isSorted(Record[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].getIdNumber() > arr[i + 1].getIdNumber()) {
                return false;
            }
        }
        return true;
    }
}