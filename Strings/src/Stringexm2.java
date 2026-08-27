import java.util.Scanner;

/**
 * Demonstrates toggling the case of characters in a string.
 * Shows three approaches:
 * 1. Using Character class methods.
 * 2. Using ASCII values directly.
 * 3. Using charAt() in a loop.
 */
public class Stringexm2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] ch = str.toCharArray();

        // Method 1: Using Character class

        System.out.print("Toggled (Character methods): ");
        for (char c1 : ch) {
            if (Character.isUpperCase(c1)) {
                System.out.print(Character.toLowerCase(c1));
            } else if (Character.isLowerCase(c1)) {
                System.out.print(Character.toUpperCase(c1));
            } else {
                System.out.print(c1);
            }
        }

        System.out.println();

        //-----------------------------------//

        // Method 2: Using ASCII values
        System.out.print("Toggled (ASCII values): ");
        for (char c2 : ch) {
            if (c2 >= 65 && c2 <= 90) {          // Uppercase A-Z
                System.out.print((char) (c2 + 32));
            } else if (c2 >= 97 && c2 <= 122) {  // Lowercase a-z
                System.out.print((char) (c2 - 32));
            } else {
                System.out.print(c2);
            }
        }

        System.out.println();

        //-----------------------------------//

        // Method 3: Using charAt() directly
        System.out.print("Toggled (charAt loop): ");
        for (int i = 0; i < str.length(); i++) {
            char ch3 = str.charAt(i);
            if (ch3 >= 'a' && ch3 <= 'z') {
                System.out.print((char) (ch3 - 32));
            } else if (ch3 >= 'A' && ch3 <= 'Z') {
                System.out.print((char) (ch3 + 32));
            } else {
                System.out.print(ch3);
            }
        }
    }
}
