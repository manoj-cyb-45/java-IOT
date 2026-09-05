import java.util.ArrayList;
import java.util.Collections;

/**
 * BucketSort class demonstrates the bucket sort algorithm.
 * Bucket Sort:
 *     Best: O(n + k)
 *     Average: O(n + k)
 *     Worst: O(n^2)
 *     Space: O(n + k)
 */
public class BucketSort {

    /**
     * Perform bucket sort on the array.
     * @param arr Array to sort
     */
    static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;

        // 1. Create n empty buckets
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Put array elements into different buckets
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // index based on value
            buckets[bucketIndex].add(num);
        }

        // 3. Sort individual buckets
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        // 4. Concatenate all buckets into arr[]
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float num : buckets[i]) {
                arr[index++] = num;
            }
        }
    }

    /**
     * Utility function to print array.
     */
    static void printArray(float[] arr) {
        for (float num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * Main method to test bucket sort.
     */
    public static void main(String[] args) {
        // Example array with values between 0 and 1
        float[] arr = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};

        System.out.println("Original Array:");
        printArray(arr);

        bucketSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }
}
