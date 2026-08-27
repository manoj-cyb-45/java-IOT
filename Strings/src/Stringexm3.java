import java.util.Scanner;

/**
 * Demonstrates palindrome checking in Java.
 * Shows two approaches:
 * 1. Brute force (reverse string and compare).
 * 2. Optimized two-pointer method.
 */
public class Stringexm3 {

    /**
     * Brute force approach:
     * Reverse the string and compare with original.
     * Time Complexity: O(N)
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    static boolean bruteforce(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
        return str.equals(rev);
    }

    /**
     * Optimized two-pointer approach:
     * Compare characters from both ends moving inward.
     * Time Complexity: O(N)
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    static boolean optimized(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Driver method to test both approaches.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Test brute force
        if (bruteforce(str)) {
            System.out.println("Brute force: Yes, it is a palindrome");
        } else {
            System.out.println("Brute force: Not a palindrome");
        }

        // Test optimized
        if (optimized(str)) {
            System.out.println("Optimized: Yes, it is a palindrome");
        } else {
            System.out.println("Optimized: Not a palindrome");
        }
    }
}
