import java.util.Scanner;

public class digitmanupulation {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N Value");
        int n=sc.nextInt();

        if(n<10)
        {
            System.out.println(n);
            return;
        }

        while(n!=0)
        {
            int R=n%10;
            System.out.print(R);
            n=n/10;
        }

    }
}
    
    