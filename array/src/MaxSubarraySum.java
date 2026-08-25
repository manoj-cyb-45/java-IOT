/**
 * Finds the maximum sum of any subarray of length k.
 * Demonstrates both brute force and optimized sliding window approaches.
 */
class BruteForce {
    /**
     * Method 1: Uses two pointers (s, e) to define a window
     * and calculates sum for each subarray of length k.
     * Time Complexity: O(N * k)
     */
    public int method1(int[] arr, int k) {
        int N = arr.length;
        int ans = Integer.MIN_VALUE;
        int s = 0, e = k - 1;

        while (e < N) {
            int sum = 0;
            for (int i = s; i <= e; i++) {
                sum += arr[i];
            }
            ans = Math.max(ans, sum);
            s++;
            e++;
        }
        return ans;
    }

    /**
     * Method 2: Iterates over all possible starting points
     * and sums exactly k elements each time.
     * Time Complexity: O(N * k)
     */
    public int method2(int[] arr, int k) {
        int N = arr.length;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i <= N - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += arr[i + j];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

/**
 * Optimized sliding window approach.
 * Time Complexity: O(N)
 */
class Optimized {
    public int solve(int[] arr, int k) {
        int N = arr.length;
        int sum = 0;

        // Step 1: Compute sum of first window
        for (int i = 0; i < k; i++) sum += arr[i];
        int ans = sum;

        // Step 2: Slide the window across the array
        for (int i = k; i < N; i++) {
            sum += arr[i] - arr[i - k]; // remove old, add new
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

/**
 * Driver class to test all methods.
 */
public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;

        BruteForce b1 = new BruteForce();
        System.out.println(b1.method1(arr, k)); // Output: 12
        System.out.println(b1.method2(arr, k)); // Output: 12

        Optimized op = new Optimized();
        System.out.println(op.solve(arr, k));   // Output: 12
    }
}
