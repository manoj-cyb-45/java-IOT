/**
 * Demonstrates basic String operations in Java.
 * Covers length, indexing, searching, case conversion,
 * substring, replacement, trimming, splitting, comparison,
 * and conversion to character array.
 */
public class Stringbascics {

    /**
     * Driver method to test String methods.
     */
    public static void main(String[] args) {
        String str = "Hello, World!";

        // Basic properties
        System.out.println("String: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Character at index 7: " + str.charAt(7));
        System.out.println("Index of 'World': " + str.indexOf("World"));

        // Searching and concatenation
        System.out.println("Contains 'World': " + str.contains("World"));
        System.out.println("Concatenated: " + str.concat(", Welcome"));

        // Case conversion
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());

        // Substring operations
        System.out.println("Substring (7 to 12): " + str.substring(7, 12));
        System.out.println("Substring (from 7): " + str.substring(7));

        // Replacement and trimming
        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));
        System.out.println("Trimmed string: " + str.trim());

        // Splitting
        System.out.println("Split by ',': " + String.join(", ", str.split(",")));

        // Prefix, suffix, equality checks
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with 'World!': " + str.endsWith("World!"));
        System.out.println("Equals 'Hello, World!': " + str.equals("Hello, World!"));
        System.out.println("EqualsIgnoreCase 'hello, world!': " + str.equalsIgnoreCase("hello, world!"));

        // Lexicographic comparison
        System.out.println("compareTo 'Hello, Java!': " + str.compareTo("Hello, Java!"));
        System.out.println("compareToIgnoreCase 'hello, java!': " + str.compareToIgnoreCase("hello, java!"));

        // Conversion to char array
        char[] charArray = str.toCharArray();
        System.out.println("First character: " + charArray[0]);
        for (char c : charArray) {
            System.out.println(c);
        }
    }
}
