import java.util.Scanner;

public class palindrome {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int original=n;

        int reverse=0;
        while(n!=0){
            int rem=n%10;
            reverse=reverse*10+rem;
            n=n/10;
        }
        if(original==reverse){
            System.out.print("Palindrome");

        }
        else{
            System.out.print("Not Palindrome");
        }
    }
}
