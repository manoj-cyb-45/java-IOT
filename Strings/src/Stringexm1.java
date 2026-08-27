import java.util.Scanner;

/**
 * Demonstrates reversing a string in Java.
 * Shows two approaches:
 * 1. Convert to char array and reverse.
 * 2. Use charAt() directly on the string.
 */
public class Stringexm1 {

    /**
     * Driver method to test string reversal.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Approach 1: Convert to char array
        char[] ch = str.toCharArray();
        System.out.print("Reversed (char array): ");
        for (int i = ch.length - 1; i >= 0; i--) {
            System.out.print(ch[i]);
        }

        System.out.println();

        //-----------------------------------//

        // Approach 2: Use charAt() directly
        System.out.print("Reversed (charAt): ");
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
}
