/* This file contains implementations of sorting algorithms.
 * You are NOT allowed to modify any of the given method headers.
 */

public class SortingAlgorithms {
    /*
     * You may define additional helper functions here if you need to.
     * Make sure the helper functions have the private access modifier, as
     * they will only be used in this class.
     */

    // Assigned to:
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

    // Assigned to:
    public void mergeSort(Record[] arr, int p, int r) {
        // TODO: Implement this sorting algorithm here.

    }

    // Assigned to:
    public void bubbleSort(Record[] arr, int n) {
        // TODO: Implement this sorting algorithm here.

    }
}

