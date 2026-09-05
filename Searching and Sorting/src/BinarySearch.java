/**
 * BinarySearch class demonstrates the binary search algorithm.
 *
 * Type: Divide and Conquer (works only on sorted arrays)
 *
 * Time Complexity:
 *   Best Case: O(1)   (element found at mid)
 *   Average Case: O(log n)
 *   Worst Case: O(log n)
 *
 * Space Complexity:
 *   Iterative: O(1)
 *   Recursive: O(log n) (stack space)
 */
public class BinarySearch {

    /**
     * Perform binary search on the array (iterative version).
     * @param arr Sorted array to search
     * @param key Element to find
     * @return Index of key if found, else -1
     */
    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key) {
                return mid; // Found at mid
            } else if (arr[mid] < key) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return -1; // Not found
    }

    /**
     * Main method to test binary search.
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // Must be sorted
        int key = 30;

        int result = binarySearch(arr, key);

        if (result != -1) {
            System.out.println("Element " + key + " found at index " + result);
        } else {
            System.out.println("Element " + key + " not found");
        }
    }
}
