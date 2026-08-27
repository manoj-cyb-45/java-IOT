import java.util.Arrays;

/**
 * Demonstrates computing prefix sums of an array.
 * Prefix sum at index i = sum of all elements from arr[0] to arr[i].
 *
 * Example:
 * arr  = {1, 2, 3}
 * psum = {1, 3, 6}
 *
 * Note:
 * - Printing an array directly (System.out.print(psum)) shows its memory reference.
 * - Use Arrays.toString(psum) to display actual contents.
 */
public class HashmapEx3 {
    public static void main(String[] args) {
        // Input array
        int[] arr = {1, 2, 3};
        int N = arr.length;

        // Prefix sum array
        int[] psum = new int[N];
        psum[0] = arr[0]; // first prefix sum is just the first element

        // Compute prefix sums iteratively
        for (int i = 1; i < N; i++) {
            psum[i] = psum[i - 1] + arr[i];
        }

        // Correct way to print array contents
        System.out.println("Prefix Sum Array: " + Arrays.toString(psum));
    }
}
