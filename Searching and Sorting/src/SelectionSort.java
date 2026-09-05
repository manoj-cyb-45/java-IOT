/**
 * SelectionSort class demonstrates the selection sort algorithm.
 * Selection Sort:
 *     Best: O(n^2)
 *     Average: O(n^2)
 *     Worst: O(n^2)
 *     Space: O(1)
 */
public class SelectionSort {

    /**
     * Perform selection sort on the array.
     * @param arr Array to sort
     */
    static void selectionSort(int[] arr) {
        int n = arr.length;

        // Outer loop: one by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Assume the minimum is at position i
            int minIndex = i;

            // Inner loop: find the actual minimum in remaining unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if smaller element found
                }
            }

            // Swap the found minimum with the first element of unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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
     * Main method to test selection sort.
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
