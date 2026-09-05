import java.util.LinkedList;
import java.util.Queue;

/**
 * PerfectNumber class generates numbers composed of digits 1 and 2
 * using a queue (BFS approach).
 */
public class PerfectNumber {

    /**
     * Generate the nth number made up of digits 1 and 2.
     * @param n Position of the number to generate
     * @return nth number composed of digits 1 and 2
     */
    static int perfectsolve(int n) {
        Queue<Integer> que = new LinkedList<>();

        // Start with base numbers 1 and 2
        que.add(1);
        que.add(2);

        int count = 0; // Counter for how many numbers generated

        while (!que.isEmpty()) {
            int val = que.poll(); // Take front element
            count++;

            // If this is the nth number, return it
            if (count == n) {
                return val;
            }

            // Generate next numbers by appending 1 and 2
            int n1 = val * 10 + 1;
            int n2 = val * 10 + 2;

            que.add(n1);
            que.add(n2);
        }

        return -1; // Should never reach here
    }

    /**
     * Main method to test perfectsolve().
     */
    public static void main(String[] args) {
        int n = 10; // Example: find the 10th number
        int result = perfectsolve(n);
        System.out.println("The " + n + "th perfect number is: " + result);
    }
}
