import java.util.HashMap;

/**
 * Demonstrates using HashMap to count frequencies of elements in an array.
 * Then iterates through the map to check if any element occurs exactly once.
 * If found, prints that element; otherwise prints "None".
 */
public class HashmapEx2 {
    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 6, 3, 8, 2, 8, 2, 8, 10, 6};

        // Step 1: Count frequencies using HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                int freq = map.get(key);
                map.put(key, freq + 1);
            } else {
                map.put(key, 1);
            }
        }

        // Step 2: Iterate through keys and check frequency
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                System.out.println(key); // prints element with frequency 1
                break;                   // exits after first match
            } else {
                System.out.println("None"); // prints "None" otherwise
            }
        }
    }
}
