import java.util.Stack;

public class Nearestsmallestnumber {

    // Brute force approach: O(n^2)
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
            result[i] = ans;
        }
        return result;
    }

    // Optimized approach using stack: O(n)
    static int[] optimized(int[] arr){
        Stack<Integer> stk = new Stack<>();
        int[] result = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            int cur = arr[i];

            // Pop until stack top is smaller
            while(!stk.isEmpty() && stk.peek() >= cur){
                stk.pop();
            }

            // If stack empty → no smaller element
            result[i] = stk.isEmpty() ? -1 : stk.peek();

            // Push current element for future comparisons
            stk.push(cur);
        }
        return result;
    }

    public static void main(String []args){
        int[] arr = {5,8,11,14,7,10,13,6,9,10,2,5};

        // Run both methods
        int[] result = bruteforce(arr);
        int[] result1 = optimized(arr);

        // Print original array
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"  ");
        }

        // Print brute force results
        System.out.println("\nBruteforce solution :");
        for(int i=0; i<result.length; i++){
            System.out.println(arr[i]+" -> "+result[i]);
        }

        // Print optimized results
        System.out.println("Optimized solution :");
        for(int i=0; i<result1.length; i++){
            System.out.println(arr[i]+" -> "+result1[i]);
        }
    }
}
