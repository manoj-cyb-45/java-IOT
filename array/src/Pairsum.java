/**
 * Class to check if a pair exists in an array
 * whose sum equals a given target k.
 * Demonstrates brute force and optimized approaches.
 */
public class Pairsum {

    /**
     * Brute force approach.
     * Checks all possible pairs (i, j).
     * Time Complexity: O(N^2)
     */
    static boolean bruteforce(int[] arr, int k) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Attempted sliding window approach.
     * Only works correctly for consecutive pairs.
     * Time Complexity: O(N)
     */
    static boolean optimized1(int[] arr, int k) {
        int sum = arr[0] + arr[1]; // first pair
        for (int i = 1; i < arr.length - 1; i++) {
            sum -= arr[i - 1];
            sum += arr[i + 1];
            if (sum == k) {
                return true;
            }
        }
        return false;
    }

    /**
     * Two-pointer approach (requires sorted array).
     * Moves pointers inward based on sum comparison.
     * Time Complexity: O(N)
     */
    static boolean optimized2(int[] arr, int k) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == k) {
                return true;
            } else if (sum > k) {
                j--; // decrease sum
            } else {
                i++; // increase sum
            }
        }
        return false;
    }

    /**
     * Driver method to test all approaches.
     */
    public static void main(String[] args) {
        int[] arr = {3, 7, 8, 11, 14, 19, 25};
        int k = 25;

        System.out.println(bruteforce(arr, k));   // true
        System.out.println(optimized1(arr, k));   // true
        System.out.println(optimized2(arr, k));   // true
    }
}
