/**
 * Class to count pairs with sum = k,
 * handling duplicates correctly using two-pointer approach.
 * Requires sorted array.
 */
public class Dupcountofpairsum {

    /**
     * Two-pointer approach with duplicate handling.
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
                int lc = 1, rc = 1;

                // Count duplicates on the left
                while (left + 1 < right && arr[left] == arr[left + 1]) {
                    lc++;
                    left++;
                }

                // Count duplicates on the right
                while (right - 1 > left && arr[right] == arr[right - 1]) {
                    rc++;
                    right--;
                }

                count += lc * rc;
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
     * Driver method to test approach.
     */
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 11;

        System.out.println(optimized2(arr, k)); // prints correct count
    }
}
