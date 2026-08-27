import java.util.Scanner;

/**
 * Finds the longest palindromic substring in a given string.
 * Demonstrates two approaches:
 * 1. Brute force (check all substrings).
 * 2. Expand-around-center (optimized).
 */
public class Stringexm5 {

    /**
     * Brute force approach:
     * Generate all substrings and check if palindrome.
     * Time Complexity: O(N^3)
     * @param st input string
     * @return longest palindromic substring
     */
    static String bruteForce(String st) {
        int N = st.length();
        String ans = "";

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                String sub = st.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }
        return ans;
    }

    // Helper method to check palindrome
    static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * Expand-around-center approach:
     * Time Complexity: O(N^2)
     * @param st input string
     * @return longest palindromic substring
     */
    static String expandCenter(String st) {
        int N = st.length();
        String ans = "";

        for (int i = 0; i < N; i++) {
            // Odd length palindrome
            int L = i, R = i;
            while (L >= 0 && R < N && st.charAt(L) == st.charAt(R)) {
                L--;
                R++;
            }
            String oddPal = st.substring(L + 1, R);
            if (oddPal.length() > ans.length()) ans = oddPal;

            // Even length palindrome
            L = i; R = i + 1;
            while (L >= 0 && R < N && st.charAt(L) == st.charAt(R)) {
                L--;
                R++;
            }
            String evenPal = st.substring(L + 1, R);
            if (evenPal.length() > ans.length()) ans = evenPal;
        }
        return ans;
    }

    /**
     * Driver method to test both approaches.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String st = sc.nextLine();

        System.out.println("Brute Force Longest Palindrome: " + bruteForce(st));
        System.out.println("Expand Center Longest Palindrome: " + expandCenter(st));
    }
}
