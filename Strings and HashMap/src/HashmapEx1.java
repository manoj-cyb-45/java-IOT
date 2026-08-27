import java.util.HashMap;

/**
 * Demonstrates frequency counting of array elements using HashMap.
 * Then answers queries about element frequencies.
 */
public class HashmapEx1 {
    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 6, 3, 8, 2, 8, 2, 8, 10, 6};

        // Queries to check frequency
        int[] Q = {2, 8, 3, 5};

        // Create HashMap to store element -> frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            if (map.containsKey(key)) {
                int freq = map.get(key);
                map.put(key, freq + 1);
            } else {
                map.put(key, 1);
            }
        }

        // Answer queries
        for (int i = 0; i < Q.length; i++) {
            int key = Q[i];
            if (map.containsKey(key)) {
                System.out.println(key + " -> " + map.get(key));
            } else {
                System.out.println(key + " -> " + 0);
            }
        }
    }
}
