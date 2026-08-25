/**
 * Class to count how many pairs exist in an array
 * whose sum equals a given target k.
 * Demonstrates brute force and optimized approaches.
 */
public class Countofpairsum {

    /**
     * Brute force approach.
     * Checks all possible pairs (i, j).
     * Time Complexity: O(N^2)
     * @param arr input array
     * @param k target sum
     * @return number of pairs with sum = k
     */
    static int bruteforce(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * Two-pointer approach (requires sorted array).
     * Moves pointers inward based on sum comparison.
     * Time Complexity: O(N)
     * @param arr sorted input array
     * @param k target sum
     * @return number of pairs with sum = k
     */
    static int optimized2(int[] arr, int k) {
        int count = 0;
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == k) {
                count++;
                left++;
                right--;
            } else if (sum > k) {
                right--; // decrease sum
            } else {
                left++; // increase sum
            }
        }
        return count;
    }

    /**
     * Driver method to test all approaches.
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int k =11 ;

        System.out.println(bruteforce(arr, k));
        System.out.println(optimized2(arr, k));
    }
}
