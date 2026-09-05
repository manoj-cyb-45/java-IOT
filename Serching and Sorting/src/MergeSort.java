/**
 * Mergesort class demonstrates the divide-and-conquer
 * merge sort algorithm on an integer array.
 * Merge Sort:
 *     Best: O(n log n)
 *     Average: O(n log n)
 *     Worst: O(n log n)
 *     Space: O(n)
 */
public class MergeSort {

    /**
     * Merge two sorted halves into a single sorted array.
     * @param arr The array to sort
     * @param l Left index
     * @param m Middle index
     * @param r Right index
     */
    static void merge(int[] arr, int l, int m, int r) {
        // Sizes of two subarrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // Temporary arrays
        int[] left = new int[n1];
        int[] right = new int[n2];

        // Copy data into temp arrays
        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int j = 0; j < n2; j++) right[j] = arr[m + 1 + j];

        // Merge temp arrays back into arr[l..r]
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    /**
     * Recursive merge sort function.
     * @param arr Array to sort
     * @param l Left index
     * @param r Right index
     */
    static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            // Sort first half
            mergeSort(arr, l, m);

            // Sort second half
            mergeSort(arr, m + 1, r);

            // Merge sorted halves
            merge(arr, l, m, r);
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
     * Main method to test merge sort.
     */
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original Array:");
        printArray(arr);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
