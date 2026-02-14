/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {
    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    private long stepCount = 0; // Helper variable used to store the empirical frequency count

    // Assigned to: Choa
    public void insertionSort(Record[] arr, int n) {
    
    // Start from index 1 as the first element is considered sorted
        incrementStep(1); // Count the initialization of i
        for (int i = 1; i < n; i++) {
            incrementStep(1); // Count the step for each outer loop iteration
        
            // Store the current element to be inserted
            Record key = arr[i];
            int j = i - 1;
            incrementStep(2); // Count the steps for key assignment and j initialization
        
            incrementStep(1); // Count the step for entering the while loop
      
            while (j >= 0 && arr[j].getIdNumber() > key.getIdNumber()) {
                incrementStep(1); // Count the step for the while condition check
            
                arr[j + 1] = arr[j];
                j--;
                incrementStep(3); // Count the steps for shifting element and decrementing j
                incrementStep(1); // Count the step for the end of the while loop iteration
            }
            incrementStep(1); // Count the step for exiting the while loop
        
            
            arr[j + 1] = key;
            incrementStep(2); // Count the steps for inserting the key
            incrementStep(1); // Count the step for the end of the outer loop iteration
        }
        incrementStep(1); // Count the step for the end of the method
    }

    // Assigned to: Patricia Nicole S. Simbahan
    public void selectionSort(Record[] arr, int n) {
        for (int i = 0; i < n - 1; i++) { // Iterate through the whole array
            int minIndex = i; // Assume the current index is the smallest
            for (int j = i + 1; j < n; j++) { // Check the rest of the array
                // Update minIndex if a smaller element is found
                if (arr[j].getIdNumber() < arr[minIndex].getIdNumber()) {
                    minIndex = j;
                }
            }
            // Swap the smallest element found with the first element of the unsorted part
            Record temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Assigned to: Lagos
    public void mergeSort(Record[] arr, int p, int r) {
        
        if (p < r) {
            int q = (p + r) / 2;
            incrementStep(1); // Count the step for calculating the midpoint

            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);

            incrementStep(1); // Count the step for the end of the if condition
        }
        incrementStep(1); // Count the step for the end of the method (base case reached)
    }

    private void merge(Record[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        incrementStep(2); // Count the steps for calculating n1 and n2

        Record[] left = new Record[n1];
        Record[] right = new Record[n2];

        // Copy data to temp arrays
        incrementStep(1); // i initialization
        for (int i = 0; i < n1; i++) {
            incrementStep(1);
            left[i] = arr[p + i];
            incrementStep(2); // Count the steps for copying an element to the left array
            incrementStep(1); // Count the step for the end of the loop iteration
        }
        incrementStep(1); // Count the step for the end of the first loop

        incrementStep(1); // j initialization
        for (int j = 0; j < n2; j++) {
            incrementStep(1);
            right[j] = arr[q + 1 + j];
            incrementStep(2); // Count the steps for copying an element to the right array
            incrementStep(1); // Count the step for the end of the loop iteration
        }
        incrementStep(1);

        int i = 0, j = 0, k = p;
        incrementStep(3); // variable initializations

        while (i < n1 && j < n2) {
            incrementStep(1); // Count the step for entering the while loop

            incrementStep(1); // Count the step for the if condition
            if (left[i].getIdNumber() <= right[j].getIdNumber()) {
                arr[k++] = left[i++];
                incrementStep(4); // Count the steps for copying an element from the left array
            } else {
                arr[k++] = right[j++];
                incrementStep(4); // Count the steps for copying an element from the right array
            }
        }
        incrementStep(1); // Count the step for exiting the while loop

        // Copy remaining elements
        while (i < n1) {
            incrementStep(1); // Count the step for entering the while loop
            arr[k++] = left[i++];
            incrementStep(3); // Count the steps for copying an element from the left array
        }
        incrementStep(1); // Count the step for exiting the while loop
        while (j < n2) {
            incrementStep(1); // Count the step for entering the while loop
            arr[k++] = right[j++];
            incrementStep(3); // Count the steps for copying an element from the right array
        }
        incrementStep(1); // Count the step for exiting the while loop

        incrementStep(1); // Count the step for the end of the merge method
    }

    // Assigned to: Lagos
    public void bubbleSort(Record[] arr, int n) {
         boolean swapped;

        //outer loop for each pass
        incrementStep(1);
        for (int i = 0; i < n - 1; i++) {
            incrementStep(1); // Count the step for each pass

            swapped = false;

            //inner loop for comparing adjacent elements
            incrementStep(1); // Count the step for entering the inner loop
            for (int j = 0; j < n - i - 1; j++) {
                incrementStep(1); // Count the comparison step

                incrementStep(1); // Count the step for the if condition
                if (arr[j].getIdNumber() > arr[j + 1].getIdNumber()) {
                    //swaps arr[j] and arr[j+1]
                    Record temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    incrementStep(3); // Count the 3 steps involved in a swap operation
                }
                incrementStep(1); // Count the step for the end of the inner loop iteration
            }
            incrementStep(1); // Count the step for the end of the outer loop iteration

            incrementStep(1); // Count the step for checking if any swaps were made in this pass
            
            //if no two elements were swapped in the inner loop, then break
            if (!swapped) {
                incrementStep(1); // Count the step for breaking out of the loop
                break;
            }
        }
    }

    /** 
     * Helper method to increment the step counter.
     * Accepts a parameter so multiple steps can be added at once
     * (e.g., 3 steps for a swap operation).
     * @param count number of steps to add to the counter
     */
    private void incrementStep(int count) {
        stepCount += count;
    }

    /** 
     * Resets the step counter back to zero.
     * This is used before running a new sorting algorithm 
     * so counts don’t carry over between runs.
     */
    public void resetStepCount() {
        stepCount = 0;
    }

    /** 
     * Retrieves the current step count.
     * This allows classes like Main.java to access the 
     * empirical frequency count after an algorithm finishes.
     * 
     * @return the current step count
     */
    public long getStepCount() {
        return stepCount;
    }
}


