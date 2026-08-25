/**
 * Class to solve Trapping Rain Water problem.
 * Demonstrates both precomputed arrays (brute force style) and
 * optimized two-pointer approach.
 */
public class Trapingrainwater {

    /**
     * Precompute leftMax and rightMax arrays.
     * Time Complexity: O(N), Space Complexity: O(N)
     * @param height input array of bar heights
     * @return total trapped water
     */
    static int bruteforce(int[] height) {
        int N = height.length;
        int[] leftmax = new int[N];
        int[] rightmax = new int[N];

        leftmax[0] = height[0];
        for (int i = 1; i < N; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }

        rightmax[N - 1] = height[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        int waterlevel = 0;
        for (int i = 0; i < N; i++) {
            int minval = Math.min(leftmax[i], rightmax[i]);
            waterlevel += minval - height[i];
        }
        return waterlevel;
    }

    /**
     * Optimized two-pointer approach.
     * Time Complexity: O(N), Space Complexity: O(1)
     * @param height input array of bar heights
     * @return total trapped water
     */
    static int optimized(int[] height) {
        int n = height.length;
        int leftmax = 0, rightmax = 0;
        int water = 0;
        int left = 0, right = n - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                leftmax = Math.max(leftmax, height[left]);
                water += leftmax - height[left];
                left++;
            } else {
                rightmax = Math.max(rightmax, height[right]);
                water += rightmax - height[right];
                right--;
            }
        }
        return water;
    }

    /**
     * Driver method to test both approaches.
     */
    public static void main(String[] args) {
        int[] arr = {4, 2, 0, 3, 2, 5};
        System.out.println(bruteforce(arr));   // Output: 9
        System.out.println(optimized(arr));    // Output: 9
    }
}
