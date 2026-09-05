/**
 * QuickSort class demonstrates the quick sort algorithm.
 * Quick Sort:
 *     Best: O(n log n)
 *     Average: O(n log n)
 *     Worst: O(n^2)
 *     Space: O(log n) (stack)
 */
public class QuickSort {

    /**
     * Partition function:
     * Places pivot element at correct position
     * and arranges smaller elements to left,
     * larger elements to right.
     */
    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1;       // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element <= pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    /**
     * QuickSort recursive function.
     * @param arr Array to sort
     * @param low Starting index
     * @param high Ending index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * Utility function to print array.
     */
    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Main method to test quick sort.
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
