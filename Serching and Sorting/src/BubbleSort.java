/**
 * BubbleSort class demonstrates the bubble sort algorithm.
 * Bubble Sort:
 *     Best: O(n)
 *     Average: O(n^2)
 *     Worst: O(n^2)
 *     Space: O(1)
 */
public class BubbleSort {

    /**
     * Perform bubble sort on the array.
     * @param arr Array to sort
     */
    static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop: number of passes
        for (int i = 0; i < n - 1; i++) {
            // Inner loop: compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
     * Main method to test bubble sort.
     */
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Original Array:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
