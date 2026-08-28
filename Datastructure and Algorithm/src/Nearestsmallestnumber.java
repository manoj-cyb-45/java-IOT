import java.util.Stack;

public class Nearestsmallestnumber {

    /**
     * Brute force approach: O(n^2)
     * For each element, scan left until a smaller element is found.
     * If none found, assign -1.
     */
    static int[] bruteforce(int[] arr){
        int[] result = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int ans = -1;          // default if no smaller element found
            int cur = arr[i];      // current element

            // Scan leftwards
            for(int j=i-1; j>=0; j--){
                if(arr[j] < cur){  // nearest smaller found
                    ans = arr[j];
                    break;
                }
            }
            result[i] = ans;       // store answer
        }
        return result;
    }

    /**
     * Optimized approach using stack (logic as written in your code).
     * Pushes current element, then pops it immediately.
     */
    static int[] optimized(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int cur = arr[i];
            stk.push(cur);

            if(stk.isEmpty()){
                result[i] = -1;
            }
            else{
                int temp = stk.pop(); // pops current element
                result[i] = temp;     // assigns it back
            }
        }
        return result;
    }

    /**
     * Main method:
     * - Defines input array
     * - Runs both brute force and optimized methods
     * - Prints original array
     * - Prints results from both approaches
     */
    public static void main(String []args){
        // Input array
        int[] arr = {5,8,11,14,7,10,13,6,9,10,2,5};

        // Run both methods
        int[] result = bruteforce(arr);
        int[] result1 = optimized(arr);

        // Print original array
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"  ");
        }

        // Print brute force results
        System.out.println("Bruteforce solution :");
        for(int i=0; i<result.length; i++){
            System.out.println(arr[i]+" -> "+result[i]);
        }

        // Print optimized results
        System.out.println("optimized solution :");
        for(int i=0; i<result.length; i++) {
            System.out.println(arr[i] + " -> " + result[i]);
        }
    }
}
