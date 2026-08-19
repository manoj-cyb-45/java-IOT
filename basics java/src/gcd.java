import java.util.Scanner;
public class gcd {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 1st number:");
        int num1 = sc.nextInt();
        System.out.print("Enter 2st number:");
        int num2 = sc.nextInt();
        int temp;
        while (num2>0){
            temp=num1%num2;
            num1=num2;
            num2=temp;
        }
        System.out.print("GCD of numbers:"+num1);
    }
}
