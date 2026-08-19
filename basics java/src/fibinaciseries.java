import java.util.Scanner;
public class fibinaciseries {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = sc.nextInt();
        int a = 0;
        int b = 1;
        int temp=0;
        for (int i=2;i<=num;i++){
            temp=a+b;
            a=b;
            b=temp;
        }
        System.out.print("Fibonacci number :"+b);
    }
}


