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
        // TODO: Implement this sorting algorithm here.

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
            mergeSort(arr, p, q);
            mergeSort(arr, q + 1, r);
            merge(arr, p, q, r);
        }
    }

    private void merge(Record[] arr, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        Record[] left = new Record[n1];
        Record[] right = new Record[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[p + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[q + 1 + j];
        }

        int i = 0, j = 0, k = p;
        while (i < n1 && j < n2) {
            if (left[i].getIdNumber() <= right[j].getIdNumber()) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) {
            arr[k++] = left[i++];
        }
        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    // Assigned to: Lagos
    public void bubbleSort(Record[] arr, int n) {
         boolean swapped;

        //outer loop for each pass
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            //inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getIdNumber() > arr[j + 1].getIdNumber()) {
                    //swaps arr[j] and arr[j+1]
                    Record temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            //if no two elements were swapped in the inner loop, then break
            if (!swapped) {
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

