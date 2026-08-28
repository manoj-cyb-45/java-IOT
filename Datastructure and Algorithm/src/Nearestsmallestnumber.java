public class Nearestsmallestnumber {
    public static void main(String []args){
        // Input array
        int[] arr={5,8,11,14,7,10,13,6,9,10,2,5};

        // Result array to store nearest smaller numbers
        int[] result=new int[arr.length];

        // Outer loop: process each element
        for(int i=0;i<arr.length;i++){
            int ans=-1;          // default value if no smaller element found
            int cur=arr[i];      // current element

            // Inner loop: look leftwards
            for(int j=i-1;j>=0;j--){
                if(arr[j]<cur){  // check if smaller element found
                    ans=arr[j];  // store it
                    break;       // stop at the nearest one
                }
            }
            result[i]=ans;       // save answer for current element
        }

        // Print original array
        for(int i=0;i< arr.length;i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();

        // Print mapping of element -> nearest smaller
        for(int i=0;i< result.length;i++){
            System.out.println(arr[i]+" -> "+result[i]);
        }
    }
}
