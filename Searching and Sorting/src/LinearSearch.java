/**
 * LinearSearch class demonstrates the linear search algorithm.
 *
 * Type: Sequential Search (works on unsorted or sorted lists)
 *
 * Time Complexity:
 *   Best Case: O(1)   (element at first position)
 *   Average Case: O(n)
 *   Worst Case: O(n)  (element at last position or not present)
 *
 * Space Complexity:
 *   O(1)   (in-place, no extra memory)
 */
public class LinearSearch {

    /**
     * Perform linear search on the array.
     * @param arr Array to search
     * @param key Element to find
     * @return Index of key if found, else -1
     */
    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // Found at index i
            }
        }
        return -1; // Not found
    }

    /**
     * Main method to test linear search.
     */
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 30;

        int result = linearSearch(arr, key);

        if (result != -1) {
            System.out.println("Element " + key + " found at index " + result);
        } else {
            System.out.println("Element " + key + " not found");
        }
    }
}
